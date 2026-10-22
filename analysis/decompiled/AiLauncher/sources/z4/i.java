package z4;

import La.H;
import La.m;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lz4/i;", "", "<init>", "()V", "", "markdown", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)I", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/util/List;", "MIN_COUNT", "I", "Lkotlin/text/Regex;", "IMAGE", "Lkotlin/text/Regex;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class i {
    public static final int MIN_COUNT = 2;
    public static final i INSTANCE = new i();
    private static final Regex IMAGE = new Regex("!\\[[^]\\n]*]\\([^)\\s]+(?:\\s+\"[^\"]*\")?\\)");

    public final int a(String markdown) {
        p.i(markdown, "markdown");
        return SequencesKt___SequencesKt.A(Regex.f(IMAGE, markdown, 0, 2, null));
    }

    public final List<String> b(String markdown) {
        p.i(markdown, "markdown");
        int last = 0;
        List<m> listD0 = SequencesKt___SequencesKt.d0(Regex.f(IMAGE, markdown, 0, 2, null));
        if (listD0.size() < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList(listD0.size() * 2);
        for (m mVar : listD0) {
            String strSubstring = markdown.substring(last, mVar.a().getFirst());
            p.h(strSubstring, "substring(...)");
            String string = H.D1(strSubstring).toString();
            if (string.length() > 0) {
                arrayList.add(string);
            }
            arrayList.add(mVar.getValue());
            last = mVar.a().getLast() + 1;
        }
        String strSubstring2 = markdown.substring(last);
        p.h(strSubstring2, "substring(...)");
        String string2 = H.D1(strSubstring2).toString();
        if (string2.length() > 0) {
            arrayList.add(string2);
        }
        return arrayList;
    }
}
