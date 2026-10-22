package com.obric.capabilitykit.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/entity/ResultCallback;", "T", "", "onResult", "", "errorCode", "", "errorMsg", "", "result", "(ILjava/lang/String;Ljava/lang/Object;)V", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ResultCallback<T> {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(ResultCallback r10, int r11, String r12, Object r13, int r14, Object r15) {
            if (r15 != null) goto L9;
            if ((r14 & 4) == 0) goto L6;
            r13 = null;
        L6:
            r10.onResult(r11, r12, r13);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResult");
        }
    }

    void onResult(int r10, @NotNull String r11, @Nullable T r12);
}
