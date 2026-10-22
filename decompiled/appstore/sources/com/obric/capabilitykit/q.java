package com.obric.capabilitykit;

import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q {

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function1<String, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11379a = null;

        static {
            f11379a = new a();
        }

        public a() {
            super(1);
        }

        @NotNull
        public final CharSequence a(@NotNull String r10) {
            kotlin.jvm.internal.q.g(r10, "it");
            return r10;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(String r10) {
            return a(r10);
        }
    }

    public static final List a(List r10) {
        kotlin.jvm.internal.q.g(r10, "appEntityList");
        ArrayList r11 = new ArrayList(kotlin.collections.u.r(r10, 10));
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(((AppEntity) r12.next()).getId());
        goto L4
    L6:
        return r11;
    }

    public static final String b(List r10) {
        kotlin.jvm.internal.q.g(r10, "array");
        return b0.h0(r10, ",", null, null, 0, null, a.f11379a, 30, null);
    }
}
