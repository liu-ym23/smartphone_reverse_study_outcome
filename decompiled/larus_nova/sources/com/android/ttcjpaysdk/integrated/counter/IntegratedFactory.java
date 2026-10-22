package com.android.ttcjpaysdk.integrated.counter;

import android.content.Context;
import android.view.View;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedDyImService;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedDyPayService;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedFullScreenService;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedGameService;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedLiteService;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedNormalService;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedStyleService;
import com.android.ttcjpaysdk.integrated.counter.adapter.ConfirmAdapterProxy;
import com.android.ttcjpaysdk.integrated.counter.adapter.MethodAdapterProxy;
import com.android.ttcjpaysdk.integrated.counter.wrapper.BaseConfirmWrapper;
import com.android.ttcjpaysdk.integrated.counter.wrapper.BaseMethodWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/IntegratedFactory;", "", "()V", "Companion", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IntegratedFactory {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nJ \u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/IntegratedFactory$Companion;", "", "()V", "getConfirmAdapter", "Lcom/android/ttcjpaysdk/integrated/counter/adapter/ConfirmAdapterProxy;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "clazz", "Ljava/lang/Class;", "type", "", "getConfirmWrapper", "Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseConfirmWrapper;", "contentView", "Landroid/view/View;", "getMethodAdapter", "Lcom/android/ttcjpaysdk/integrated/counter/adapter/MethodAdapterProxy;", "getMethodWrapper", "Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseMethodWrapper;", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ConfirmAdapterProxy getConfirmAdapter(Context r100, int r101) {
            if (r101 != 0) goto L4;
            ConfirmAdapterProxy r102 = getConfirmAdapter(r100, ICJPayIntegratedNormalService.class);
        L22:
            if (r102 == null) goto L24;
            return r102;
        L24:
            return getConfirmAdapter(r100, ICJPayIntegratedNormalService.class);
        L4:
            if (r101 != 1) goto L6;
            r102 = getConfirmAdapter(r100, ICJPayIntegratedFullScreenService.class);
            goto L22
        L6:
            if (r101 != 2) goto L8;
            r102 = getConfirmAdapter(r100, ICJPayIntegratedGameService.class);
            goto L22
        L8:
            if (r101 != 3) goto L10;
            r102 = getConfirmAdapter(r100, ICJPayIntegratedLiteService.class);
            goto L22
        L10:
            if (r101 != 4) goto L12;
            r102 = getConfirmAdapter(r100, ICJPayIntegratedDyImService.class);
            goto L22
        L12:
            if (r101 != 6) goto L14;
        L16:
            r102 = getConfirmAdapter(r100, ICJPayIntegratedDyPayService.class);
            goto L22
        L14:
            if (r101 == 7) goto L16;
            r102 = null;
            goto L22
        }

        public final BaseConfirmWrapper getConfirmWrapper(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "contentView");
            if (r101 != 0) goto L5;
            BaseConfirmWrapper r102 = getConfirmWrapper(r100, ICJPayIntegratedNormalService.class);
        L23:
            if (r102 == null) goto L25;
            return r102;
        L25:
            return getConfirmWrapper(r100, ICJPayIntegratedNormalService.class);
        L5:
            if (r101 != 1) goto L7;
            r102 = getConfirmWrapper(r100, ICJPayIntegratedFullScreenService.class);
            goto L23
        L7:
            if (r101 != 2) goto L9;
            r102 = getConfirmWrapper(r100, ICJPayIntegratedGameService.class);
            goto L23
        L9:
            if (r101 != 3) goto L11;
            r102 = getConfirmWrapper(r100, ICJPayIntegratedLiteService.class);
            goto L23
        L11:
            if (r101 != 4) goto L13;
            r102 = getConfirmWrapper(r100, ICJPayIntegratedDyImService.class);
            goto L23
        L13:
            if (r101 != 6) goto L15;
        L17:
            r102 = getConfirmWrapper(r100, ICJPayIntegratedDyPayService.class);
            goto L23
        L15:
            if (r101 == 7) goto L17;
            r102 = null;
            goto L23
        }

        public final MethodAdapterProxy getMethodAdapter(Context r100, int r101) {
            if (r101 != 0) goto L4;
            MethodAdapterProxy r102 = getMethodAdapter(r100, ICJPayIntegratedNormalService.class);
        L16:
            if (r102 == null) goto L18;
            return r102;
        L18:
            return getMethodAdapter(r100, ICJPayIntegratedNormalService.class);
        L4:
            if (r101 != 1) goto L6;
            r102 = getMethodAdapter(r100, ICJPayIntegratedFullScreenService.class);
            goto L16
        L6:
            if (r101 != 4) goto L8;
            r102 = getMethodAdapter(r100, ICJPayIntegratedDyImService.class);
            goto L16
        L8:
            if (r101 != 6) goto L10;
        L12:
            r102 = getMethodAdapter(r100, ICJPayIntegratedDyPayService.class);
            goto L16
        L10:
            if (r101 == 7) goto L12;
            r102 = null;
            goto L16
        }

        public final BaseMethodWrapper getMethodWrapper(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "contentView");
            if (r101 != 0) goto L5;
            BaseMethodWrapper r102 = getMethodWrapper(r100, ICJPayIntegratedNormalService.class);
        L17:
            if (r102 == null) goto L19;
            return r102;
        L19:
            return getMethodWrapper(r100, ICJPayIntegratedNormalService.class);
        L5:
            if (r101 != 1) goto L7;
            r102 = getMethodWrapper(r100, ICJPayIntegratedFullScreenService.class);
            goto L17
        L7:
            if (r101 != 4) goto L9;
            r102 = getMethodWrapper(r100, ICJPayIntegratedDyImService.class);
            goto L17
        L9:
            if (r101 != 6) goto L11;
        L13:
            r102 = getMethodWrapper(r100, ICJPayIntegratedDyPayService.class);
            goto L17
        L11:
            if (r101 == 7) goto L13;
            r102 = null;
            goto L17
        }

        private final ConfirmAdapterProxy getConfirmAdapter(Context r100, Class<?> r101) {
            ICJPayIntegratedStyleService r102 = (ICJPayIntegratedStyleService) CJPayServiceManager.getInstance().getIService(r101);
            if (r102 == null) goto L5;
            Object r103 = r102.getConfirmAdapter(r100);
        L7:
            if ((r103 instanceof ConfirmAdapterProxy) == true) goto L9;
            return null;
        L9:
            return (ConfirmAdapterProxy) r103;
        L5:
            r103 = null;
            goto L7
        }

        private final BaseConfirmWrapper getConfirmWrapper(View r100, Class<?> r101) {
            ICJPayIntegratedStyleService r102 = (ICJPayIntegratedStyleService) CJPayServiceManager.getInstance().getIService(r101);
            if (r102 == null) goto L5;
            Object r103 = r102.getConfirmWrapper(r100);
        L7:
            if ((r103 instanceof BaseConfirmWrapper) == true) goto L9;
            return null;
        L9:
            return (BaseConfirmWrapper) r103;
        L5:
            r103 = null;
            goto L7
        }

        private final MethodAdapterProxy getMethodAdapter(Context r100, Class<?> r101) {
            ICJPayIntegratedStyleService r102 = (ICJPayIntegratedStyleService) CJPayServiceManager.getInstance().getIService(r101);
            if (r102 == null) goto L5;
            Object r103 = r102.getMethodAdapter(r100);
        L7:
            if ((r103 instanceof MethodAdapterProxy) == true) goto L9;
            return null;
        L9:
            return (MethodAdapterProxy) r103;
        L5:
            r103 = null;
            goto L7
        }

        private final BaseMethodWrapper getMethodWrapper(View r100, Class<?> r101) {
            ICJPayIntegratedStyleService r102 = (ICJPayIntegratedStyleService) CJPayServiceManager.getInstance().getIService(r101);
            if (r102 == null) goto L5;
            Object r103 = r102.getMethodWrapper(r100);
        L7:
            if ((r103 instanceof BaseMethodWrapper) == true) goto L9;
            return null;
        L9:
            return (BaseMethodWrapper) r103;
        L5:
            r103 = null;
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    public IntegratedFactory() {
    }
}
