package bytekn.foundation.utils;

import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f21810a = 0;

    public static final class a {
        public static int a(String r100, String r101) {
            if (r100 == null) goto L9;
            Sequence r102 = Regex.findAll$default(new Regex(r101), r100, 0, 2, null);
            if (r102.iterator().hasNext() == true) goto L8;
            return -1;
        L8:
            return ((MatchResult) SequencesKt.last(r102)).getRange().getFirst();
        L9:
            return -1;
        }
    }

    static {
    }
}
