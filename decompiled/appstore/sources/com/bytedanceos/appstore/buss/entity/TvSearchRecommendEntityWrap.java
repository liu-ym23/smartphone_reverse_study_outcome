package com.bytedanceos.appstore.buss.entity;

import androidx.annotation.WorkerThread;
import c9.a;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B=\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003JI\u0010\u0018\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0086@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0003H\u0087@¢\u0006\u0002\u0010\u001fJ\t\u0010!\u001a\u00020\"HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006$"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/TvSearchRecommendEntityWrap;", "", ServerElements.HOT_APPS, "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", ServerElements.HOT_KEYWORDS, "Lcom/bytedanceos/appstore/buss/entity/TvSearchHotKeywordsEntity;", ServerElements.RECOMMEND_APPS, "Lcom/bytedanceos/appstore/buss/entity/TvSearchRecommendAppsEntity;", ServerElements.HOT_KEYWORDS_LINE, "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;I)V", "getHot_apps", "()Ljava/util/List;", "getHot_keywords", "setHot_keywords", "(Ljava/util/List;)V", "getHot_keywords_line", "()I", "getRecommend_apps", "component1", "component2", "component3", "component4", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "hotConvertAppEntityWrap", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recommendConvertListAppEntityWrap", "toString", "", "Companion", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSearchRecommendEntityWrap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchRecommendEntityWrap.kt\ncom/bytedanceos/appstore/buss/entity/TvSearchRecommendEntityWrap\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,62:1\n1855#2,2:63\n*S KotlinDebug\n*F\n+ 1 SearchRecommendEntityWrap.kt\ncom/bytedanceos/appstore/buss/entity/TvSearchRecommendEntityWrap\n*L\n34#1:63,2\n*E\n"})
public final class TvSearchRecommendEntityWrap {

    @NotNull
    public static final Companion Companion = null;
    public static final int MIN_SEARCH_HOT_APP_COUNT = 8;
    public static final int SEARCH_RECOMMEND_APP_COUNT = 6;

    @Nullable
    private final List<CommonAppEntity> hot_apps;

    @Nullable
    private List<TvSearchHotKeywordsEntity> hot_keywords;
    private final int hot_keywords_line;

    @Nullable
    private final List<TvSearchRecommendAppsEntity> recommend_apps;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/TvSearchRecommendEntityWrap$Companion;", "", "()V", "MIN_SEARCH_HOT_APP_COUNT", "", "SEARCH_RECOMMEND_APP_COUNT", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TvSearchRecommendEntityWrap(@Nullable List<CommonAppEntity> r10, @Nullable List<TvSearchHotKeywordsEntity> r11, @Nullable List<TvSearchRecommendAppsEntity> r12, int r13) {
        this.hot_apps = r10;
        this.hot_keywords = r11;
        this.recommend_apps = r12;
        this.hot_keywords_line = r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TvSearchRecommendEntityWrap copy$default(TvSearchRecommendEntityWrap r10, List r11, List r12, List r13, int r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.hot_apps;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.hot_keywords;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.recommend_apps;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.hot_keywords_line;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    @Nullable
    public final List<CommonAppEntity> component1() {
        return this.hot_apps;
    }

    @Nullable
    public final List<TvSearchHotKeywordsEntity> component2() {
        return this.hot_keywords;
    }

    @Nullable
    public final List<TvSearchRecommendAppsEntity> component3() {
        return this.recommend_apps;
    }

    public final int component4() {
        return this.hot_keywords_line;
    }

    @NotNull
    public final TvSearchRecommendEntityWrap copy(@Nullable List<CommonAppEntity> r10, @Nullable List<TvSearchHotKeywordsEntity> r11, @Nullable List<TvSearchRecommendAppsEntity> r12, int r13) {
        return new TvSearchRecommendEntityWrap(r10, r11, r12, r13);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TvSearchRecommendEntityWrap) == true) goto L8;
        return false;
    L8:
        TvSearchRecommendEntityWrap r11 = (TvSearchRecommendEntityWrap) r10;
        if (q.b(this.hot_apps, r11.hot_apps) == true) goto L12;
        return false;
    L12:
        if (q.b(this.hot_keywords, r11.hot_keywords) == true) goto L15;
        return false;
    L15:
        if (q.b(this.recommend_apps, r11.recommend_apps) == true) goto L18;
        return false;
    L18:
        if (this.hot_keywords_line == r11.hot_keywords_line) goto L20;
        return false;
    L20:
        return true;
    }

    @Nullable
    public final List<CommonAppEntity> getHot_apps() {
        return this.hot_apps;
    }

    @Nullable
    public final List<TvSearchHotKeywordsEntity> getHot_keywords() {
        return this.hot_keywords;
    }

    public final int getHot_keywords_line() {
        return this.hot_keywords_line;
    }

    @Nullable
    public final List<TvSearchRecommendAppsEntity> getRecommend_apps() {
        return this.recommend_apps;
    }

    public int hashCode() {
        List<CommonAppEntity> r10 = this.hot_apps;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        List<TvSearchHotKeywordsEntity> r14 = this.hot_keywords;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        List<TvSearchRecommendAppsEntity> r17 = this.recommend_apps;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return ((r16 + r11) * 31) + Integer.hashCode(this.hot_keywords_line);
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Nullable
    public final Object hotConvertAppEntityWrap(@NotNull Continuation<? super AppEntityWrap> r19) {
        List<CommonAppEntity> r10 = this.hot_apps;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.isEmpty() == false) goto L8;
        return null;
    L8:
        return new AppEntityWrap(null, null, null, null, a.g(this.hot_apps, 8), null, null, null, null, 0, 0, null, null, 8175, null);
    }

    @WorkerThread
    @Nullable
    public final Object recommendConvertListAppEntityWrap(@NotNull Continuation<? super List<AppEntityWrap>> r22) {
        List<TvSearchRecommendAppsEntity> r10 = this.recommend_apps;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.isEmpty() == true) goto L26;
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = this.recommend_apps.iterator();
    L9:
        if (r12.hasNext() == false) goto L16;
        TvSearchRecommendAppsEntity r13 = (TvSearchRecommendAppsEntity) r12.next();
        List<CommonAppEntity> r14 = r13.getInfo();
        if (r14 == null) goto L9;
        if (r14.isEmpty() == true) goto L9;
        List r15 = a.g(r13.getInfo(), 6);
        r11.add(new AppEntityWrap(r13.getName(), null, null, null, r15, null, null, null, null, 0, 0, null, null, 8174, null));
        goto L9
    L16:
        return r11;
    L26:
        return null;
    }

    public final void setHot_keywords(@Nullable List<TvSearchHotKeywordsEntity> r10) {
        this.hot_keywords = r10;
    }

    @NotNull
    public String toString() {
        return "TvSearchRecommendEntityWrap(hot_apps=" + this.hot_apps + ", hot_keywords=" + this.hot_keywords + ", recommend_apps=" + this.recommend_apps + ", hot_keywords_line=" + this.hot_keywords_line + ')';
    }
}
