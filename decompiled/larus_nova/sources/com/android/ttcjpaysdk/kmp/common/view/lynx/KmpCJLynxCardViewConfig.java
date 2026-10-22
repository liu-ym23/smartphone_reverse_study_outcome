package com.android.ttcjpaysdk.kmp.common.view.lynx;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001c\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/lynx/KmpCJLynxCardViewConfig;", "", "<init>", "()V", "fitContentWidth", "", "getFitContentWidth$annotations", "getFitContentWidth", "()Z", "setFitContentWidth", "(Z)V", "fitContentHeight", "getFitContentHeight$annotations", "getFitContentHeight", "setFitContentHeight", "background", "Landroidx/compose/ui/graphics/Color;", "getBackground-0d7_KjU", "()J", "setBackground-8_81llA", "(J)V", "J", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpCJLynxCardViewConfig {
    public static final int $stable = 8;
    private long background;
    private boolean fitContentHeight;
    private boolean fitContentWidth;

    public static /* synthetic */ void getFitContentHeight$annotations() {
    }

    public static /* synthetic */ void getFitContentWidth$annotations() {
    }

    public KmpCJLynxCardViewConfig() {
        this.background = Color.Companion.m4863getUnspecified0d7_KjU();
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m8082getBackground0d7_KjU() {
        return this.background;
    }

    public final boolean getFitContentHeight() {
        return this.fitContentHeight;
    }

    public final boolean getFitContentWidth() {
        return this.fitContentWidth;
    }

    /* JADX INFO: renamed from: setBackground-8_81llA, reason: not valid java name */
    public final void m8083setBackground8_81llA(long r100) {
        this.background = r100;
    }

    public final void setFitContentHeight(boolean r100) {
        this.fitContentHeight = r100;
    }

    public final void setFitContentWidth(boolean r100) {
        this.fitContentWidth = r100;
    }
}
