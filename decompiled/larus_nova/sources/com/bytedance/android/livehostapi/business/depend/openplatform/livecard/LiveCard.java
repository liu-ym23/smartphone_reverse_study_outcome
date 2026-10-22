package com.bytedance.android.livehostapi.business.depend.openplatform.livecard;

import android.view.Surface;
import android.view.View;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001$B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0019J\u0018\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0019J\u0016\u0010#\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000f¨\u0006%"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/openplatform/livecard/LiveCard;", "", "cardView", "Landroid/view/View;", "width", "", "height", "cardOperator", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/livecard/LiveCard$IMiniAppCardOperator;", "(Landroid/view/View;IILcom/bytedance/android/livehostapi/business/depend/openplatform/livecard/LiveCard$IMiniAppCardOperator;)V", "getCardView", "()Landroid/view/View;", "getHeight", "()I", "setHeight", "(I)V", "mPosition", "Lkotlin/Pair;", "getMPosition", "()Lkotlin/Pair;", "setMPosition", "(Lkotlin/Pair;)V", "getWidth", "setWidth", "close", "", "hide", "pauseCast", "resumeCast", "show", "startCast", "surface", "Landroid/view/Surface;", "fps", "stopCast", "updateSize", "IMiniAppCardOperator", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCard {
    private final IMiniAppCardOperator cardOperator;
    private final View cardView;
    private int height;
    private Pair<Integer, Integer> mPosition;
    private int width;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH&¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/openplatform/livecard/LiveCard$IMiniAppCardOperator;", "", "close", "", "hide", "pauseCast", "resumeCast", "show", "startCast", "surface", "Landroid/view/Surface;", "fps", "", "stopCast", "updateCastConfig", "updateSize", "width", "height", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IMiniAppCardOperator {
        void close();

        void hide();

        void pauseCast();

        void resumeCast();

        void show();

        void startCast(Surface r100, int r101);

        void stopCast();

        void updateCastConfig(int r100);

        void updateSize(int r100, int r101);
    }

    public final void close() {
        IMiniAppCardOperator r100 = this.cardOperator;
        if (r100 == null) goto L6;
        r100.close();
        return;
    }

    public final void hide() {
        IMiniAppCardOperator r100 = this.cardOperator;
        if (r100 == null) goto L6;
        r100.hide();
        return;
    }

    public final void pauseCast() {
        IMiniAppCardOperator r100 = this.cardOperator;
        if (r100 == null) goto L6;
        r100.pauseCast();
        return;
    }

    public final void resumeCast() {
        IMiniAppCardOperator r100 = this.cardOperator;
        if (r100 == null) goto L6;
        r100.resumeCast();
        return;
    }

    public final void show() {
        IMiniAppCardOperator r100 = this.cardOperator;
        if (r100 == null) goto L6;
        r100.show();
        return;
    }

    public final void stopCast() {
        IMiniAppCardOperator r100 = this.cardOperator;
        if (r100 == null) goto L6;
        r100.stopCast();
        return;
    }

    public final View getCardView() {
        return this.cardView;
    }

    public final int getHeight() {
        return this.height;
    }

    public final Pair<Integer, Integer> getMPosition() {
        return this.mPosition;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setMPosition(Pair<Integer, Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mPosition = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public final void startCast(Surface r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "surface");
        IMiniAppCardOperator r102 = this.cardOperator;
        if (r102 == null) goto L6;
        r102.startCast(r100, r101);
        return;
    }

    public final void updateSize(int r100, int r101) {
        IMiniAppCardOperator r102 = this.cardOperator;
        if (r102 == null) goto L6;
        r102.updateSize(r100, r101);
        return;
    }

    public LiveCard(View r100, int r101, int r102, IMiniAppCardOperator r103) {
        this.cardView = r100;
        this.width = r101;
        this.height = r102;
        this.cardOperator = r103;
        this.mPosition = new Pair(0, 0);
    }

    public static /* synthetic */ void startCast$default(LiveCard r100, Surface r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = -1;
    L5:
        r100.startCast(r101, r102);
    }
}
