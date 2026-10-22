package com.obric.utils;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClickUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/utils/ClickUtils;", "", "()V", "OnMultiClickListener", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClickUtils {

    /* JADX INFO: compiled from: ClickUtils.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/utils/ClickUtils$OnMultiClickListener;", "Landroid/view/View$OnClickListener;", "triggerClickCount", "", "clickInterval", "", "(IJ)V", "clickCount", "lastClickTime", "onBeforeTriggerClick", "", BaseSwitches.V, "Landroid/view/View;", "count", "onClick", "onTriggerClick", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class OnMultiClickListener implements View.OnClickListener {
        public static final Companion Companion = null;
        private static final long INTERVAL_DEFAULT_VALUE = 500;
        private int clickCount;
        private final long clickInterval;
        private long lastClickTime;
        private final int triggerClickCount;

        /* JADX INFO: compiled from: ClickUtils.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/utils/ClickUtils$OnMultiClickListener$Companion;", "", "()V", "INTERVAL_DEFAULT_VALUE", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        public OnMultiClickListener(int r7) {
            this(r7, 0, 2, null);
        }

        public void onBeforeTriggerClick(View r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, BaseSwitches.V);
        }

        public abstract void onTriggerClick(View r1);

        public OnMultiClickListener(int r1, long r2) {
            this.triggerClickCount = r1;
            this.clickInterval = r2;
        }

        public /* synthetic */ OnMultiClickListener(int r1, long r2, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 2) == 0) goto L5;
            r2 = 500;
        L5:
            this(r1, r2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r9) {
            Intrinsics.checkNotNullParameter(r9, BaseSwitches.V);
            if (this.triggerClickCount > 1) goto L6;
            onTriggerClick(r9);
            return;
        L6:
            long r2 = System.currentTimeMillis();
            if ((r2 - this.lastClickTime) >= this.clickInterval) goto L14;
            int r0 = this.clickCount + 1;
            this.clickCount = r0;
            int r4 = this.triggerClickCount;
            if (r0 != r4) goto L11;
            onTriggerClick(r9);
        L15:
            this.lastClickTime = r2;
            return;
        L11:
            if (r0 >= r4) goto L13;
            onBeforeTriggerClick(r9, r0);
            goto L15
        L13:
            this.clickCount = 1;
            onBeforeTriggerClick(r9, 1);
            goto L15
        L14:
            this.clickCount = 1;
            onBeforeTriggerClick(r9, 1);
            goto L15
        }
    }

    public ClickUtils() {
    }
}
