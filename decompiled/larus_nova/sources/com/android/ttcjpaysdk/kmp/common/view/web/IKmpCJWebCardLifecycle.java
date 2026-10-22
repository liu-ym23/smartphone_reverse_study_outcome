package com.android.ttcjpaysdk.kmp.common.view.web;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0017J\b\u0010\u0005\u001a\u00020\u0003H\u0017J\b\u0010\u0006\u001a\u00020\u0003H\u0017J\b\u0010\u0007\u001a\u00020\u0003H\u0017J\b\u0010\b\u001a\u00020\u0003H\u0017J\b\u0010\t\u001a\u00020\u0003H\u0017J\b\u0010\n\u001a\u00020\u0003H\u0017¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/web/IKmpCJWebCardLifecycle;", "", "onPageBegin", "", "onPageEnd", LynxVideoManagerLite.EVENT_ON_PROGRESS_CHANGE, "onErrorReceive", "onHttpErrorReceive", "onFirstContentfulPaint", "onFirstMeaningfulPaint", "onLargestContentfulPaint", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJWebCardLifecycle {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onErrorReceive(IKmpCJWebCardLifecycle r100) {
        }

        public static void onFirstContentfulPaint(IKmpCJWebCardLifecycle r100) {
        }

        public static void onFirstMeaningfulPaint(IKmpCJWebCardLifecycle r100) {
        }

        public static void onHttpErrorReceive(IKmpCJWebCardLifecycle r100) {
        }

        public static void onLargestContentfulPaint(IKmpCJWebCardLifecycle r100) {
        }

        public static void onPageBegin(IKmpCJWebCardLifecycle r100) {
        }

        public static void onPageEnd(IKmpCJWebCardLifecycle r100) {
        }

        public static void onProgressChange(IKmpCJWebCardLifecycle r100) {
        }
    }

    void onErrorReceive();

    void onFirstContentfulPaint();

    void onFirstMeaningfulPaint();

    void onHttpErrorReceive();

    void onLargestContentfulPaint();

    void onPageBegin();

    void onPageEnd();

    void onProgressChange();
}
