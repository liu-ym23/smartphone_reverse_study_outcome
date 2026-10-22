package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingOutput;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbBackBlock;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbBackBlock$BackBlockInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "BackBlockInput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbBackBlock extends AbsJSBMethod<BackBlockInput, NothingOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbBackBlock$BackBlockInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "title", "", PerfLog.PARAM_KEY_CONTEXT_ID, "policy", "", "confirm", "cancel", "enable_animation", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BackBlockInput implements IJSBParams {
        public String cancel;
        public String confirm;
        public String context;
        public String enable_animation;
        public int policy;
        public String title;

        public BackBlockInput() {
            this(null, null, 0, null, null, null, 63, null);
        }

        public BackBlockInput(String r100, String r101, int r102, String r103, String r104, String r105) {
            Intrinsics.checkNotNullParameter(r100, "title");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r103, "confirm");
            Intrinsics.checkNotNullParameter(r104, "cancel");
            Intrinsics.checkNotNullParameter(r105, "enable_animation");
            this.title = r100;
            this.context = r101;
            this.policy = r102;
            this.confirm = r103;
            this.cancel = r104;
            this.enable_animation = r105;
        }

        public /* synthetic */ BackBlockInput(String r100, String r101, int r102, String r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 1) == 0) goto L5;
            String r114 = "";
        L7:
            if ((r112 & 2) == 0) goto L9;
            String r104 = "";
        L11:
            if ((r112 & 4) == 0) goto L13;
            int r105 = -1;
        L15:
            if ((r112 & 8) == 0) goto L17;
            String r106 = "";
        L19:
            if ((r112 & 16) == 0) goto L21;
            String r107 = "";
        L23:
            if ((r112 & 32) == 0) goto L25;
            String r115 = "";
        L26:
            this(r114, r104, r105, r106, r107, r115);
            return;
        L25:
            r115 = r111;
            goto L26
        L21:
            r107 = r110;
            goto L23
        L17:
            r106 = r103;
            goto L19
        L13:
            r105 = r102;
            goto L15
        L9:
            r104 = r101;
            goto L11
        L5:
            r114 = r100;
            goto L7
        }
    }

    public AbsJsbBackBlock() {
        this.name = "ttcjpay.backBlock";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
