package io.ktor.network.tls;

import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LWa/p;", "Lio/ktor/network/tls/TLSRecord;", "LY8/t;", "<anonymous>", "(LWa/p;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.network.tls.TLSClientHandshake$input$1", f = "TLSClientHandshake.kt", l = {63, 93}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class TLSClientHandshake$input$1 extends SuspendLambda implements p<Wa.p<? super TLSRecord>, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ ByteReadChannel $rawInput;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ TLSClientHandshake this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TLSRecordType.values().length];
            try {
                iArr[TLSRecordType.Alert.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TLSRecordType.ChangeCipherSpec.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TLSClientHandshake$input$1(ByteReadChannel byteReadChannel, TLSClientHandshake tLSClientHandshake, InterfaceC4014c<? super TLSClientHandshake$input$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$rawInput = byteReadChannel;
        this.this$0 = tLSClientHandshake;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TLSClientHandshake$input$1 tLSClientHandshake$input$1 = new TLSClientHandshake$input$1(this.$rawInput, this.this$0, interfaceC4014c);
        tLSClientHandshake$input$1.L$0 = obj;
        return tLSClientHandshake$input$1;
    }

    @Override // p9.p
    public final Object invoke(Wa.p<? super TLSRecord> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((TLSClientHandshake$input$1) create(pVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0058 A[Catch: all -> 0x0028, ClosedReceiveChannelException -> 0x0134, TryCatch #3 {ClosedReceiveChannelException -> 0x0134, all -> 0x0028, blocks: (B:7:0x0024, B:17:0x003f, B:20:0x0054, B:22:0x0058, B:24:0x0064, B:27:0x0078, B:31:0x00a9, B:34:0x00b1, B:35:0x00cc, B:36:0x00cd, B:37:0x00d4, B:38:0x00d5, B:40:0x00ed, B:43:0x00f9, B:14:0x0035), top: B:57:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d5 A[Catch: all -> 0x0028, ClosedReceiveChannelException -> 0x0134, TryCatch #3 {ClosedReceiveChannelException -> 0x0134, all -> 0x0028, blocks: (B:7:0x0024, B:17:0x003f, B:20:0x0054, B:22:0x0058, B:24:0x0064, B:27:0x0078, B:31:0x00a9, B:34:0x00b1, B:35:0x00cc, B:36:0x00cd, B:37:0x00d4, B:38:0x00d5, B:40:0x00ed, B:43:0x00f9, B:14:0x0035), top: B:57:0x0010 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a4 -> B:17:0x003f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00af -> B:17:0x003f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.TLSClientHandshake$input$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
