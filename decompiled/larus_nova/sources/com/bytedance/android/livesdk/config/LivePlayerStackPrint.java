package com.bytedance.android.livesdk.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/config/LivePlayerStackPrint;", "", "enable_player_print_stack", "", "player_stack_depth", "", "(ZI)V", "getEnable_player_print_stack", "()Z", "getPlayer_stack_depth", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerStackPrint {
    private final boolean enable_player_print_stack;
    private final int player_stack_depth;

    /* JADX WARN: Multi-variable type inference failed */
    public LivePlayerStackPrint() {
        boolean r100 = false;
        Object[] r101 = 0 == true ? 1 : 0;
        this(r100, r101, 3, null);
    }

    public static /* synthetic */ LivePlayerStackPrint copy$default(LivePlayerStackPrint r100, boolean r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enable_player_print_stack;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.player_stack_depth;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.enable_player_print_stack;
    }

    public final int component2() {
        return this.player_stack_depth;
    }

    public final LivePlayerStackPrint copy(boolean r100, int r101) {
        return new LivePlayerStackPrint(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LivePlayerStackPrint) == false) goto L10;
        LivePlayerStackPrint r101 = (LivePlayerStackPrint) r100;
        if (this.enable_player_print_stack == r101.enable_player_print_stack) goto L8;
        return false;
    L8:
        if (this.player_stack_depth == r101.player_stack_depth) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean r100 = this.enable_player_print_stack;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (r101 * 31) + this.player_stack_depth;
    }

    public String toString() {
        return "LivePlayerStackPrint(enable_player_print_stack=" + this.enable_player_print_stack + ", player_stack_depth=" + this.player_stack_depth + ")";
    }

    public final boolean getEnable_player_print_stack() {
        return this.enable_player_print_stack;
    }

    public final int getPlayer_stack_depth() {
        return this.player_stack_depth;
    }

    public LivePlayerStackPrint(boolean r100, int r101) {
        this.enable_player_print_stack = r100;
        this.player_stack_depth = r101;
    }

    public /* synthetic */ LivePlayerStackPrint(boolean r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 10;
    L8:
        this(r100, r101);
    }
}
