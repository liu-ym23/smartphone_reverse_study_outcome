package com.stepos.ailauncher.chat.view;

import android.view.ViewGroup;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/view/U5;", "", "Landroid/view/ViewGroup;", Parameters.ROOT, "", "padLeft", "padTop", "padRight", "padBottom", "<init>", "(Landroid/view/ViewGroup;IIII)V", "Landroid/view/ViewGroup;", "c", "()Landroid/view/ViewGroup;", "I", Const.INTENT_KEY_APIKEY, "()I", Const.INTENT_KEY_PKGNAME, "getPadRight", "getPadBottom", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class U5 {
    private final int padBottom;
    private final int padLeft;
    private final int padRight;
    private final int padTop;
    private final ViewGroup root;

    public U5(ViewGroup root, int i10, int i11, int i12, int i13) {
        kotlin.jvm.internal.p.i(root, "root");
        this.root = root;
        this.padLeft = i10;
        this.padTop = i11;
        this.padRight = i12;
        this.padBottom = i13;
    }

    /* renamed from: a, reason: from getter */
    public final int getPadLeft() {
        return this.padLeft;
    }

    /* renamed from: b, reason: from getter */
    public final int getPadTop() {
        return this.padTop;
    }

    /* renamed from: c, reason: from getter */
    public final ViewGroup getRoot() {
        return this.root;
    }
}
