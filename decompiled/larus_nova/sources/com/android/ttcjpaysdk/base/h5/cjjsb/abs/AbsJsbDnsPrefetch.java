package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.ss.ttvideoengine.net.DNSParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDnsPrefetch;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDnsPrefetch$DnsPrefetchInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDnsPrefetch$DnsPrefetchOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "DnsPrefetchInput", "DnsPrefetchOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbDnsPrefetch extends AbsJSBMethod<DnsPrefetchInput, DnsPrefetchOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDnsPrefetch$DnsPrefetchInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "host", "", "(Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DnsPrefetchInput implements IJSBParams {
        public String host;

        /* JADX WARN: Multi-variable type inference failed */
        public DnsPrefetchInput() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public DnsPrefetchInput(String r100) {
            Intrinsics.checkNotNullParameter(r100, "host");
            this.host = r100;
        }

        public /* synthetic */ DnsPrefetchInput(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = "";
        L5:
            this(r100);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDnsPrefetch$DnsPrefetchOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", DNSParser.DNS_RESULT_IP, "", "(Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DnsPrefetchOutput extends JSBBaseOutput {

        /* JADX INFO: renamed from: ip, reason: collision with root package name */
        public String f29341ip;

        /* JADX WARN: Multi-variable type inference failed */
        public DnsPrefetchOutput() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public DnsPrefetchOutput(String r100) {
            Intrinsics.checkNotNullParameter(r100, DNSParser.DNS_RESULT_IP);
            this.f29341ip = r100;
        }

        public /* synthetic */ DnsPrefetchOutput(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = "";
        L5:
            this(r100);
        }
    }

    public AbsJsbDnsPrefetch() {
        this.name = "ttcjpay.dnsPrefetch";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
