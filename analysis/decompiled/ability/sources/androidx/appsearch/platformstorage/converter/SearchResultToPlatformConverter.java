package androidx.appsearch.platformstorage.converter;

import android.annotation.SuppressLint;
import android.app.appsearch.SearchResult;
import android.os.Build;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.app.SearchResult;
import androidx.appsearch.platformstorage.util.AppSearchVersionUtil;
import androidx.core.util.Preconditions;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class SearchResultToPlatformConverter {
    private static final String TAG = "AppSearchSearchResPlatC";

    @RequiresApi(36)
    public static class ApiHelperForB {
        private ApiHelperForB() {
        }

        @DoNotInline
        @SuppressLint({"NewApi"})
        public static List<Double> getInformationalRankingSignals(SearchResult searchResult) {
            return searchResult.getInformationalRankingSignals();
        }

        @DoNotInline
        public static Map<String, List<String>> getParentTypeMap(SearchResult searchResult) {
            return searchResult.getParentTypeMap();
        }
    }

    @RequiresApi(33)
    public static class ApiHelperForT {
        private ApiHelperForT() {
        }

        @DoNotInline
        public static int getSubmatchRangeEnd(SearchResult.MatchInfo matchInfo) {
            return matchInfo.getSubmatchRange().getEnd();
        }

        @DoNotInline
        public static int getSubmatchRangeStart(SearchResult.MatchInfo matchInfo) {
            return matchInfo.getSubmatchRange().getStart();
        }
    }

    @RequiresApi(34)
    public static class ApiHelperForU {
        private ApiHelperForU() {
        }

        @DoNotInline
        public static List<SearchResult> getJoinedResults(SearchResult searchResult) {
            return searchResult.getJoinedResults();
        }
    }

    private SearchResultToPlatformConverter() {
    }

    private static SearchResult.MatchInfo toJetpackMatchInfo(SearchResult.MatchInfo matchInfo) {
        Preconditions.checkNotNull(matchInfo);
        SearchResult.MatchInfo.Builder snippetRange = new SearchResult.MatchInfo.Builder(matchInfo.getPropertyPath()).setExactMatchRange(new SearchResult.MatchRange(matchInfo.getExactMatchRange().getStart(), matchInfo.getExactMatchRange().getEnd())).setSnippetRange(new SearchResult.MatchRange(matchInfo.getSnippetRange().getStart(), matchInfo.getSnippetRange().getEnd()));
        snippetRange.setSubmatchRange(new SearchResult.MatchRange(ApiHelperForT.getSubmatchRangeStart(matchInfo), ApiHelperForT.getSubmatchRangeEnd(matchInfo)));
        return snippetRange.build();
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public static androidx.appsearch.app.SearchResult toJetpackSearchResult(android.app.appsearch.SearchResult searchResult) {
        Preconditions.checkNotNull(searchResult);
        SearchResult.Builder rankingSignal = new SearchResult.Builder(searchResult.getPackageName(), searchResult.getDatabaseName()).setGenericDocument(GenericDocumentToPlatformConverter.toJetpackGenericDocument(searchResult.getGenericDocument())).setRankingSignal(searchResult.getRankingSignal());
        List<SearchResult.MatchInfo> matchInfos = searchResult.getMatchInfos();
        for (int i = 0; i < matchInfos.size(); i++) {
            rankingSignal.addMatchInfo(toJetpackMatchInfo(matchInfos.get(i)));
        }
        if (Build.VERSION.SDK_INT >= 34) {
            Iterator<android.app.appsearch.SearchResult> it = ApiHelperForU.getJoinedResults(searchResult).iterator();
            while (it.hasNext()) {
                rankingSignal.addJoinedResult(toJetpackSearchResult(it.next()));
            }
        }
        if (AppSearchVersionUtil.isAtLeastB()) {
            List<Double> informationalRankingSignals = ApiHelperForB.getInformationalRankingSignals(searchResult);
            for (int i6 = 0; i6 < informationalRankingSignals.size(); i6++) {
                rankingSignal.addInformationalRankingSignal(informationalRankingSignals.get(i6).doubleValue());
            }
            try {
                rankingSignal.setParentTypeMap(ApiHelperForB.getParentTypeMap(searchResult));
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "Failed to set parent type map.", e);
            }
        }
        return rankingSignal.build();
    }
}
