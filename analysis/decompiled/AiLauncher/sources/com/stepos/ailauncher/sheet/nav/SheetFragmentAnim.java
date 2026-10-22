package com.stepos.ailauncher.sheet.nav;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B/\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/sheet/nav/b;", "", "", "enter", "exit", "popEnter", "popExit", "<init>", "(IIII)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_UMID, "e", "Companion", Const.INTENT_KEY_APIKEY, "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.sheet.nav.b, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SheetFragmentAnim {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SheetFragmentAnim None = new SheetFragmentAnim(0, 0, 0, 0);
    private final int enter;
    private final int exit;
    private final int popEnter;
    private final int popExit;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/sheet/nav/b$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/sheet/nav/b;", "None", "Lcom/stepos/ailauncher/sheet/nav/b;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/sheet/nav/b;", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sheet.nav.b$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final SheetFragmentAnim a() {
            return SheetFragmentAnim.None;
        }

        public Companion() {
        }
    }

    public SheetFragmentAnim(int i10, int i11, int i12, int i13) {
        this.enter = i10;
        this.exit = i11;
        this.popEnter = i12;
        this.popExit = i13;
    }

    /* renamed from: b, reason: from getter */
    public final int getEnter() {
        return this.enter;
    }

    /* renamed from: c, reason: from getter */
    public final int getExit() {
        return this.exit;
    }

    /* renamed from: d, reason: from getter */
    public final int getPopEnter() {
        return this.popEnter;
    }

    /* renamed from: e, reason: from getter */
    public final int getPopExit() {
        return this.popExit;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SheetFragmentAnim)) {
            return false;
        }
        SheetFragmentAnim sheetFragmentAnim = (SheetFragmentAnim) other;
        return this.enter == sheetFragmentAnim.enter && this.exit == sheetFragmentAnim.exit && this.popEnter == sheetFragmentAnim.popEnter && this.popExit == sheetFragmentAnim.popExit;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.enter) * 31) + Integer.hashCode(this.exit)) * 31) + Integer.hashCode(this.popEnter)) * 31) + Integer.hashCode(this.popExit);
    }

    public String toString() {
        return "SheetFragmentAnim(enter=" + this.enter + ", exit=" + this.exit + ", popEnter=" + this.popEnter + ", popExit=" + this.popExit + ")";
    }
}
