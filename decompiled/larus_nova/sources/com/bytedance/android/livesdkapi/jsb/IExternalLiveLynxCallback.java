package com.bytedance.android.livesdkapi.jsb;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0001 J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H&J\u001a\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u001a\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u001a\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u001bH&J\u001a\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u001bH&J\u001a\u0010\u001d\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u0003H&J\"\u0010\u001d\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0005H&¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveLynxCallback;", "", "enableInvoke", "", "jsbName", "", "params", "Lorg/json/JSONObject;", "schema", "onFallback", "errorCode", "", "errorMessage", "onFirstScreen", "", "lynxView", "Landroid/view/View;", "onInnerFallback", "onLoadFailed", "errMsg", "onLoadSuccess", "onPageStart", "url", "onReceivedError", "info", "onRuntimeReady", "onScrollStart", "Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveLynxCallback$ExternalLiveLynxScrollInfo;", "onScrollStop", "onTemplateLoaded", "isOffline", "resFrom", "ExternalLiveLynxScrollInfo", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExternalLiveLynxCallback {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveLynxCallback$ExternalLiveLynxScrollInfo;", "", "tagName", "", "scrollMonitorTag", "(Ljava/lang/String;Ljava/lang/String;)V", "getScrollMonitorTag", "()Ljava/lang/String;", "getTagName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ExternalLiveLynxScrollInfo {
        private final String scrollMonitorTag;
        private final String tagName;

        public static /* synthetic */ ExternalLiveLynxScrollInfo copy$default(ExternalLiveLynxScrollInfo r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.tagName;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.scrollMonitorTag;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.tagName;
        }

        public final String component2() {
            return this.scrollMonitorTag;
        }

        public final ExternalLiveLynxScrollInfo copy(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tagName");
            Intrinsics.checkNotNullParameter(r101, "scrollMonitorTag");
            return new ExternalLiveLynxScrollInfo(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ExternalLiveLynxScrollInfo) == false) goto L10;
            ExternalLiveLynxScrollInfo r101 = (ExternalLiveLynxScrollInfo) r100;
            if (Intrinsics.areEqual(this.tagName, r101.tagName) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.scrollMonitorTag, r101.scrollMonitorTag) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r100 = this.tagName;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.scrollMonitorTag;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "ExternalLiveLynxScrollInfo(tagName=" + this.tagName + ", scrollMonitorTag=" + this.scrollMonitorTag + ")";
        }

        public final String getScrollMonitorTag() {
            return this.scrollMonitorTag;
        }

        public final String getTagName() {
            return this.tagName;
        }

        public ExternalLiveLynxScrollInfo(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tagName");
            Intrinsics.checkNotNullParameter(r101, "scrollMonitorTag");
            this.tagName = r100;
            this.scrollMonitorTag = r101;
        }
    }

    boolean enableInvoke(String r100, JSONObject r101, String r102);

    boolean onFallback(int r100, String r101);

    void onFirstScreen(View r100);

    void onInnerFallback(int r100, String r101);

    void onLoadFailed(View r100, String r101);

    void onLoadSuccess(View r100);

    void onPageStart(View r100, String r101);

    void onReceivedError(View r100, String r101);

    void onRuntimeReady(View r100);

    void onScrollStart(View r100, ExternalLiveLynxScrollInfo r101);

    void onScrollStop(View r100, ExternalLiveLynxScrollInfo r101);

    void onTemplateLoaded(View r100, boolean r101);

    void onTemplateLoaded(View r100, boolean r101, String r102);
}
