package com.stepos.agentframework.uikit;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/uikit/O;", "", "<init>", "()V", "", "markdown", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Z", "normalizedMarkdown", "c", "", "e", "(Ljava/lang/String;)Ljava/util/List;", "lines", Const.INTENT_KEY_UMID, "(Ljava/util/List;)Z", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class O {
    public static final O INSTANCE = new O();

    public static final String f(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return La.H.D1(it).toString();
    }

    public final boolean b(String markdown) {
        kotlin.jvm.internal.p.i(markdown, "markdown");
        if (La.H.f0(markdown, '|', false, 2, null)) {
            return c(Q.INSTANCE.h(markdown));
        }
        return false;
    }

    public final boolean c(String normalizedMarkdown) {
        kotlin.jvm.internal.p.i(normalizedMarkdown, "normalizedMarkdown");
        List<String> listE = e(normalizedMarkdown);
        if (!d(listE)) {
            return false;
        }
        List<String> list = listE;
        Q q10 = Q.INSTANCE;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (q10.d((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean d(List<String> lines) {
        List<String> list = lines;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (String str : list) {
            if (La.H.g0(str, "|", false, 2, null)) {
                int i10 = 0;
                for (int i11 = 0; i11 < str.length(); i11++) {
                    if (str.charAt(i11) == '|') {
                        i10++;
                    }
                }
                if (i10 >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final List<String> e(String markdown) {
        return SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.R(La.H.E0(markdown), new InterfaceC5074l() { // from class: com.stepos.agentframework.uikit.N
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return O.f((String) obj);
            }
        }));
    }
}
