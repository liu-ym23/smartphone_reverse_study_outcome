package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCJModalView;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCJModalView$CJModalViewInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "CJModalViewInput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbCJModalView extends AbsJSBMethod<CJModalViewInput, NothingOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tR\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCJModalView$CJModalViewInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "url", "", "enable_animation", "", "fullpage", "background_color", "show_loading", "(Ljava/lang/String;IILjava/lang/String;I)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJModalViewInput implements IJSBParams {
        public String background_color;
        public int enable_animation;
        public int fullpage;
        public int show_loading;
        public String url;

        public CJModalViewInput() {
            this(null, 0, 0, null, 0, 31, null);
        }

        public CJModalViewInput(String r100, int r101, int r102, String r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r103, "background_color");
            this.url = r100;
            this.enable_animation = r101;
            this.fullpage = r102;
            this.background_color = r103;
            this.show_loading = r104;
        }

        public /* synthetic */ CJModalViewInput(String r100, int r101, int r102, String r103, int r104, int r110, DefaultConstructorMarker r111) {
            String r105 = "";
            if ((r110 & 1) == 0) goto L5;
            String r112 = "";
        L7:
            if ((r110 & 2) == 0) goto L9;
            int r106 = 0;
        L11:
            if ((r110 & 4) == 0) goto L13;
            int r107 = 0;
        L15:
            if ((r110 & 8) != 0) goto L19;
            r105 = r103;
        L19:
            if ((r110 & 16) == 0) goto L21;
            int r113 = 0;
        L22:
            this(r112, r106, r107, r105, r113);
            return;
        L21:
            r113 = r104;
            goto L22
        L13:
            r107 = r102;
            goto L15
        L9:
            r106 = r101;
            goto L11
        L5:
            r112 = r100;
            goto L7
        }
    }

    public AbsJsbCJModalView() {
        this.name = "ttcjpay.CJModalView";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
