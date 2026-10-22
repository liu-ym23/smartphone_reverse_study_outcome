package com.obric.autogui.common.api.platform.input;

import android.view.KeyEvent;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.m;

/* JADX INFO: compiled from: IAutoActionInputApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionInputApi {

    /* JADX INFO: compiled from: IAutoActionInputApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object swipe$default(IAutoActionInputApi r9, m r10, m r11, long r12, boolean r14, d r15, int r16, Object r17) {
            IAutoActionInputApi r2 = (IAutoActionInputApi) ZeusTransformUtils.wrapperContextForParams(r9, IAutoActionInputApi.class, "com.obric.aiagent.plugin");
            d<? super e> r8 = (d) ZeusTransformUtils.wrapperContextForParams(r15, d.class, "com.obric.aiagent.plugin");
            if (r17 != null) goto L15;
            if ((r16 & 4) == 0) goto L7;
            long r5 = 750;
        L9:
            if ((r16 & 8) == 0) goto L11;
            boolean r7 = com.obric.autogui.common.a.d.f28974a.X();
        L13:
            return r2.swipe(r10, r11, r5, r7, r8);
        L11:
            r7 = r14;
            goto L13
        L7:
            r5 = r12;
            goto L9
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: swipe");
        }

        public static /* synthetic */ Object tap$default(IAutoActionInputApi r9, float r10, float r11, long r12, InjectEventContext.Context r14, d r15, int r16, Object r17) {
            IAutoActionInputApi r2 = (IAutoActionInputApi) ZeusTransformUtils.wrapperContextForParams(r9, IAutoActionInputApi.class, "com.obric.aiagent.plugin");
            d<? super e> r8 = (d) ZeusTransformUtils.wrapperContextForParams(r15, d.class, "com.obric.aiagent.plugin");
            if (r17 != null) goto L15;
            if ((r16 & 4) == 0) goto L7;
            long r5 = -1;
        L9:
            if ((r16 & 8) == 0) goto L11;
            InjectEventContext.Context r7 = null;
        L13:
            return r2.tap(r10, r11, r5, r7, r8);
        L11:
            r7 = r14;
            goto L13
        L7:
            r5 = r12;
            goto L9
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tap");
        }

        public static /* synthetic */ Object inputText$default(IAutoActionInputApi r2, AOOperatingSpace r3, String r4, boolean r5, d r6, int r7, Object r8) {
            IAutoActionInputApi r9 = (IAutoActionInputApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionInputApi.class, "com.obric.aiagent.plugin");
            AOOperatingSpace r10 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r3, AOOperatingSpace.class, "com.obric.aiagent.plugin");
            d<? super InputTextResult> r11 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L10;
            if ((r7 & 4) == 0) goto L8;
            r5 = false;
        L8:
            return r9.inputText(r10, r4, r5, r11);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: inputText");
        }
    }

    Object inputText(AOOperatingSpace r1, String r2, boolean r3, d<? super InputTextResult> r4);

    e key(DisplayAccessor r1, int r2);

    e key(DisplayAccessor r1, KeyEvent r2);

    e key(AOOperatingSpace r1, int r2);

    boolean registerInjectTextResponseListener(InjectTextResponseListener r1);

    Object scrollAtCoordinate(int r1, float r2, float r3, int r4, int r5, d<? super CoordinateScrollResult> r6);

    Object swipe(m<Float, Float> r1, m<Float, Float> r2, long r3, boolean r5, d<? super e> r6);

    Object swipeV3Tail(int r1, m<Float, Float> r2, m<Float, Float> r3, d<? super e> r4);

    Object tap(float r1, float r2, long r3, InjectEventContext.Context r5, d<? super e> r6);

    boolean unregisterInjectTextResponseListener(InjectTextResponseListener r1);
}
