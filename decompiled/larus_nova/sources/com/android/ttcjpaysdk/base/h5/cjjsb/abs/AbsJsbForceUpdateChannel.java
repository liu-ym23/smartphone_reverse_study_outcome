package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingOutput;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbForceUpdateChannel;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbForceUpdateChannel$ForceUpdateChannelInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "ForceUpdateChannelInput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbForceUpdateChannel extends AbsJSBMethod<ForceUpdateChannelInput, NothingOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fR\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbForceUpdateChannel$ForceUpdateChannelInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "gecko_app", "", "access_key", "channels", "", "disable_throttle", "", "download_priority", "", "loop_level", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZII)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ForceUpdateChannelInput implements IJSBParams {
        public String access_key;
        public List<String> channels;
        public boolean disable_throttle;
        public int download_priority;
        public String gecko_app;
        public int loop_level;

        public ForceUpdateChannelInput() {
            this(null, null, null, false, 0, 0, 63, null);
        }

        public ForceUpdateChannelInput(String r100, String r101, List<String> r102, boolean r103, int r104, int r105) {
            Intrinsics.checkNotNullParameter(r100, "gecko_app");
            Intrinsics.checkNotNullParameter(r101, "access_key");
            Intrinsics.checkNotNullParameter(r102, "channels");
            this.gecko_app = r100;
            this.access_key = r101;
            this.channels = r102;
            this.disable_throttle = r103;
            this.download_priority = r104;
            this.loop_level = r105;
        }

        public /* synthetic */ ForceUpdateChannelInput(String r100, String r101, List r102, boolean r103, int r104, int r110, int r111, DefaultConstructorMarker r112) {
            String r105 = "";
            if ((r111 & 1) == 0) goto L5;
            String r113 = "";
        L7:
            if ((r111 & 2) != 0) goto L11;
            r105 = r101;
        L11:
            if ((r111 & 4) == 0) goto L13;
            r102 = CollectionsKt.emptyList();
        L13:
            List r106 = r102;
            if ((r111 & 8) == 0) goto L16;
            boolean r107 = true;
        L18:
            if ((r111 & 16) == 0) goto L20;
            int r108 = 3;
        L22:
            if ((r111 & 32) == 0) goto L24;
            int r114 = 0;
        L25:
            this(r113, r105, r106, r107, r108, r114);
            return;
        L24:
            r114 = r110;
            goto L25
        L20:
            r108 = r104;
            goto L22
        L16:
            r107 = r103;
            goto L18
        L5:
            r113 = r100;
            goto L7
        }
    }

    public AbsJsbForceUpdateChannel() {
        this.name = "ttcjpay.forceUpdateChannel";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
