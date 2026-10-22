package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCheckLivePlugin;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCheckLivePlugin$CheckLivePluginInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCheckLivePlugin$CheckLivePluginOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "CheckLivePluginInput", "CheckLivePluginOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbCheckLivePlugin extends AbsJSBMethod<CheckLivePluginInput, CheckLivePluginOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCheckLivePlugin$CheckLivePluginInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "is_only_check", "", "is_install_background", "(ZZ)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CheckLivePluginInput implements IJSBParams {
        public boolean is_install_background;
        public boolean is_only_check;

        public CheckLivePluginInput() {
            boolean r100 = false;
            this(r100, r100, 3, null);
        }

        public CheckLivePluginInput(boolean r100, boolean r101) {
            this.is_only_check = r100;
            this.is_install_background = r101;
        }

        public /* synthetic */ CheckLivePluginInput(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = true;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = false;
        L8:
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCheckLivePlugin$CheckLivePluginOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "is_available", "", "(Z)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CheckLivePluginOutput extends JSBBaseOutput {
        public boolean is_available;

        public CheckLivePluginOutput() {
            boolean r100 = false;
            this(r100, 1, null);
        }

        public CheckLivePluginOutput(boolean r100) {
            this.is_available = r100;
        }

        public /* synthetic */ CheckLivePluginOutput(boolean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = false;
        L5:
            this(r100);
        }
    }

    public AbsJsbCheckLivePlugin() {
        this.name = "ttcjpay.checkLivePlugin";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
