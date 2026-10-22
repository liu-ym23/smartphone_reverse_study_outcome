package com.stepos.ailauncher.chat.input.controller;

import android.view.View;
import android.view.ViewGroup;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0011\u001a\u00020\u00102\u001a\u0010\u000f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0018\u00010\t¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/chat/input/controller/a;", "", "<init>", "()V", "Landroid/view/View;", "view", "", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;)F", "", "Lkotlin/Pair;", "Landroid/view/ViewGroup;", "", "c", "(Landroid/view/View;)Ljava/util/List;", "saved", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)V", "SLIDE_FRACTION", "F", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.input.controller.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2656a {
    public static final C2656a INSTANCE = new C2656a();
    private static final float SLIDE_FRACTION = 0.2f;

    public final void a(List<? extends Pair<? extends ViewGroup, Boolean>> saved) {
        if (saved != null) {
            Iterator<T> it = saved.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                ((ViewGroup) pair.a()).setClipChildren(((Boolean) pair.b()).booleanValue());
            }
        }
    }

    public final float b(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        Integer numValueOf = Integer.valueOf(view.getRootView().getHeight());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        return (numValueOf != null ? numValueOf.intValue() : view.getResources().getDisplayMetrics().heightPixels) * 0.2f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<kotlin.Pair<android.view.ViewGroup, java.lang.Boolean>> c(android.view.View r3) {
        /*
            r2 = this;
            java.lang.String r2 = "view"
            kotlin.jvm.internal.p.i(r3, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            android.view.ViewParent r3 = r3.getParent()
            boolean r0 = r3 instanceof android.view.ViewGroup
            r1 = 0
            if (r0 == 0) goto L17
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            goto L18
        L17:
            r3 = r1
        L18:
            if (r3 == 0) goto L38
            boolean r0 = r3.getClipChildren()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            kotlin.Pair r0 = Y8.j.a(r3, r0)
            r2.add(r0)
            r0 = 0
            r3.setClipChildren(r0)
            android.view.ViewParent r3 = r3.getParent()
            boolean r0 = r3 instanceof android.view.ViewGroup
            if (r0 == 0) goto L17
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            goto L18
        L38:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.input.controller.C2656a.c(android.view.View):java.util.List");
    }
}
