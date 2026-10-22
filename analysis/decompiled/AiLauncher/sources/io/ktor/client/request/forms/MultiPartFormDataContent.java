package io.ktor.client.request.forms;

import Z8.C1174w;
import Z8.F;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import fb.C4074a;
import fb.s;
import fb.v;
import fb.x;
import g9.InterfaceC4112d;
import io.ktor.client.request.forms.PreparedPart;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.PartData;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R(\u0010#\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lio/ktor/client/request/forms/MultiPartFormDataContent;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "", "Lio/ktor/http/content/PartData;", "parts", "", "boundary", "Lio/ktor/http/ContentType;", "contentType", "<init>", "(Ljava/util/List;Ljava/lang/String;Lio/ktor/http/ContentType;)V", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "LY8/t;", "writeTo", "(Lio/ktor/utils/io/ByteWriteChannel;Le9/c;)Ljava/lang/Object;", "Ljava/lang/String;", "getBoundary", "()Ljava/lang/String;", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "", "BOUNDARY_BYTES", "[B", "LAST_BOUNDARY_BYTES", "", "BODY_OVERHEAD_SIZE", "I", "PART_OVERHEAD_SIZE", "Lio/ktor/client/request/forms/PreparedPart;", "rawParts", "Ljava/util/List;", "", UxipConstants.f30680s, "contentLength", "Ljava/lang/Long;", "getContentLength", "()Ljava/lang/Long;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MultiPartFormDataContent extends OutgoingContent.WriteChannelContent {
    private final int BODY_OVERHEAD_SIZE;
    private final byte[] BOUNDARY_BYTES;
    private final byte[] LAST_BOUNDARY_BYTES;
    private final int PART_OVERHEAD_SIZE;
    private final String boundary;
    private Long contentLength;
    private final ContentType contentType;
    private final List<PreparedPart> rawParts;

    @InterfaceC4112d(c = "io.ktor.client.request.forms.MultiPartFormDataContent", f = "FormDataContent.kt", l = {124, 125, 126, 131, 135, 139, 142, 146, 146, 146}, m = "writeTo")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.request.forms.MultiPartFormDataContent$writeTo$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultiPartFormDataContent.this.writeTo(null, this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MultiPartFormDataContent(List list, String str, ContentType contentType, int i10, kotlin.jvm.internal.i iVar) {
        str = (i10 & 2) != 0 ? FormDataContentKt.generateBoundary() : str;
        this(list, str, (i10 & 4) != 0 ? ContentType.MultiPart.INSTANCE.getFormData().withParameter("boundary", str) : contentType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v rawParts$lambda$3$lambda$2(byte[] bArr) {
        C4074a c4074a = new C4074a();
        BytePacketBuilderKt.writeFully$default(c4074a, bArr, 0, 0, 6, null);
        return c4074a;
    }

    public final String getBoundary() {
        return this.boundary;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        return this.contentLength;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.contentType;
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x0229, code lost:
    
        if (r4.flushAndClose(r2) != r3) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0248, code lost:
    
        if (r7.flushAndClose(r2) == r3) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01b8, code lost:
    
        if (io.ktor.utils.io.ByteReadChannelOperationsKt.copyTo(r1, r7, r2) == r3) goto L122;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0203 A[Catch: all -> 0x01ff, TRY_ENTER, TRY_LEAVE, TryCatch #13 {all -> 0x01ff, blocks: (B:47:0x00de, B:49:0x00e4, B:104:0x0203), top: B:149:0x00de }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e4 A[Catch: all -> 0x01ff, TRY_LEAVE, TryCatch #13 {all -> 0x01ff, blocks: (B:47:0x00de, B:49:0x00e4, B:104:0x0203), top: B:149:0x00de }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014b A[Catch: all -> 0x007c, TRY_LEAVE, TryCatch #12 {all -> 0x007c, blocks: (B:63:0x0147, B:65:0x014b, B:71:0x0183, B:80:0x0192, B:81:0x0195, B:82:0x0196, B:84:0x019a, B:94:0x01e9, B:95:0x01ee, B:26:0x0077, B:36:0x00ab, B:39:0x00bc, B:42:0x00cc, B:78:0x0190), top: B:148:0x0025, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0196 A[Catch: all -> 0x007c, TryCatch #12 {all -> 0x007c, blocks: (B:63:0x0147, B:65:0x014b, B:71:0x0183, B:80:0x0192, B:81:0x0195, B:82:0x0196, B:84:0x019a, B:94:0x01e9, B:95:0x01ee, B:26:0x0077, B:36:0x00ab, B:39:0x00bc, B:42:0x00cc, B:78:0x0190), top: B:148:0x0025, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01e1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x01e1 -> B:22:0x0064). Please report as a decompilation issue!!! */
    @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object writeTo(io.ktor.utils.io.ByteWriteChannel r25, e9.InterfaceC4014c<? super Y8.t> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.request.forms.MultiPartFormDataContent.writeTo(io.ktor.utils.io.ByteWriteChannel, e9.c):java.lang.Object");
    }

    public MultiPartFormDataContent(List<? extends PartData> parts, String boundary, ContentType contentType) {
        PreparedPart channelPart;
        p.i(parts, "parts");
        p.i(boundary, "boundary");
        p.i(contentType, "contentType");
        this.boundary = boundary;
        this.contentType = contentType;
        Long l10 = null;
        byte[] byteArray$default = StringsKt.toByteArray$default("--" + boundary + ServerSentEventKt.END_OF_LINE, null, 1, null);
        this.BOUNDARY_BYTES = byteArray$default;
        byte[] byteArray$default2 = StringsKt.toByteArray$default("--" + boundary + "--\r\n", null, 1, null);
        this.LAST_BOUNDARY_BYTES = byteArray$default2;
        this.BODY_OVERHEAD_SIZE = byteArray$default2.length;
        this.PART_OVERHEAD_SIZE = (FormDataContentKt.RN_BYTES.length * 2) + byteArray$default.length;
        List<? extends PartData> list = parts;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (PartData partData : list) {
            s sVarBytePacketBuilder = BytePacketBuilderKt.BytePacketBuilder();
            for (Map.Entry<String, List<String>> entry : partData.getHeaders().entries()) {
                StringsKt.writeText$default(sVarBytePacketBuilder, entry.getKey() + ": " + F.A0(entry.getValue(), "; ", null, null, 0, null, null, 62, null), 0, 0, (Charset) null, 14, (Object) null);
                BytePacketBuilderKt.writeFully$default(sVarBytePacketBuilder, FormDataContentKt.RN_BYTES, 0, 0, 6, null);
            }
            Headers headers = partData.getHeaders();
            HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
            String str = headers.get(httpHeaders.getContentLength());
            Long lValueOf = str != null ? Long.valueOf(Long.parseLong(str)) : null;
            if (partData instanceof PartData.FileItem) {
                channelPart = new PreparedPart.ChannelPart(x.c(BytePacketBuilderKt.build(sVarBytePacketBuilder)), ((PartData.FileItem) partData).getProvider(), lValueOf != null ? Long.valueOf(lValueOf.longValue() + this.PART_OVERHEAD_SIZE + r6.length) : null);
            } else if (partData instanceof PartData.BinaryItem) {
                channelPart = new PreparedPart.InputPart(x.c(BytePacketBuilderKt.build(sVarBytePacketBuilder)), ((PartData.BinaryItem) partData).getProvider(), lValueOf != null ? Long.valueOf(lValueOf.longValue() + this.PART_OVERHEAD_SIZE + r6.length) : null);
            } else if (partData instanceof PartData.FormItem) {
                C4074a c4074a = new C4074a();
                StringsKt.writeText$default(c4074a, ((PartData.FormItem) partData).getValue(), 0, 0, (Charset) null, 14, (Object) null);
                final byte[] bArrC = x.c(c4074a);
                InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: io.ktor.client.request.forms.k
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return MultiPartFormDataContent.rawParts$lambda$3$lambda$2(bArrC);
                    }
                };
                if (lValueOf == null) {
                    StringsKt.writeText$default(sVarBytePacketBuilder, httpHeaders.getContentLength() + ": " + bArrC.length, 0, 0, (Charset) null, 14, (Object) null);
                    BytePacketBuilderKt.writeFully$default(sVarBytePacketBuilder, FormDataContentKt.RN_BYTES, 0, 0, 6, null);
                }
                channelPart = new PreparedPart.InputPart(x.c(BytePacketBuilderKt.build(sVarBytePacketBuilder)), interfaceC5063a, Long.valueOf(bArrC.length + this.PART_OVERHEAD_SIZE + r4.length));
            } else if (partData instanceof PartData.BinaryChannelItem) {
                channelPart = new PreparedPart.ChannelPart(x.c(BytePacketBuilderKt.build(sVarBytePacketBuilder)), ((PartData.BinaryChannelItem) partData).getProvider(), lValueOf != null ? Long.valueOf(lValueOf.longValue() + this.PART_OVERHEAD_SIZE + r6.length) : null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(channelPart);
        }
        this.rawParts = arrayList;
        Long lValueOf2 = 0L;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                l10 = lValueOf2;
                break;
            }
            Long size = ((PreparedPart) it.next()).getSize();
            if (size == null) {
                break;
            } else {
                lValueOf2 = lValueOf2 != null ? Long.valueOf(lValueOf2.longValue() + size.longValue()) : null;
            }
        }
        this.contentLength = l10 != null ? Long.valueOf(l10.longValue() + this.BODY_OVERHEAD_SIZE) : l10;
    }
}
