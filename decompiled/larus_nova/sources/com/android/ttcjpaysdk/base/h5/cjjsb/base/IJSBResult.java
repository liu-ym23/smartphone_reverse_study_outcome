package com.android.ttcjpaysdk.base.h5.cjjsb.base;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bJ\u001e\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u001e\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\n\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBResult;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "onFailed", "", "errorMsg", "", "result", "Lorg/json/JSONObject;", "onFatal", "onSuccess", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IJSBResult extends CJPayObject, Serializable {
    public static final Companion Companion = null;
    public static final int FATAL_ERROR_CODE = 999;
    public static final int NORMAL_ERROR_CODE = 1;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBResult$Companion;", "", "()V", "FATAL_ERROR_CODE", "", "NORMAL_ERROR_CODE", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int FATAL_ERROR_CODE = 999;
        public static final int NORMAL_ERROR_CODE = 1;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onFailed$default(IJSBResult r100, String r101, JSONObject r102, int r103, Object r104) {
            if (r104 != null) goto L12;
            if ((r103 & 1) == 0) goto L7;
            r101 = "";
        L7:
            if ((r103 & 2) == 0) goto L9;
            r102 = null;
        L9:
            r100.onFailed(r101, r102);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailed");
        }

        public static /* synthetic */ void onFatal$default(IJSBResult r100, String r101, JSONObject r102, int r103, Object r104) {
            if (r104 != null) goto L12;
            if ((r103 & 1) == 0) goto L7;
            r101 = "";
        L7:
            if ((r103 & 2) == 0) goto L9;
            r102 = null;
        L9:
            r100.onFatal(r101, r102);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFatal");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void onFailed(String r100, JSONObject r101);

    void onFatal(String r100, JSONObject r101);

    void onSuccess();

    void onSuccess(JSONObject r100);
}
