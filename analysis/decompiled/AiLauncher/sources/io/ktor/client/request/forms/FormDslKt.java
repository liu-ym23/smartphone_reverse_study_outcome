package io.ktor.client.request.forms;

import Y8.t;
import fb.C4074a;
import fb.s;
import fb.v;
import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.HeaderValueWithParametersKt;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.PartData;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000H\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001a\u0010\u0002\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u0000\"\u0006\u0012\u0002\b\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u0005\u0010\u000b\u001aX\u0010\u0014\u001a\u00020\t*\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0014\b\u0004\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0004 \u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001aZ\u0010\u0014\u001a\u00020\t*\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0007\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0005 \u0001¢\u0006\u0004\b\u0014\u0010\u0019\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001a"}, d2 = {"", "Lio/ktor/client/request/forms/FormPart;", "values", "", "Lio/ktor/http/content/PartData;", "formData", "([Lio/ktor/client/request/forms/FormPart;)Ljava/util/List;", "Lkotlin/Function1;", "Lio/ktor/client/request/forms/FormBuilder;", "LY8/t;", "block", "(Lp9/l;)Ljava/util/List;", "", "key", "Lio/ktor/http/Headers;", "headers", "", ContentDisposition.Parameters.Size, "Lfb/s;", "bodyBuilder", "append", "(Lio/ktor/client/request/forms/FormBuilder;Ljava/lang/String;Lio/ktor/http/Headers;Ljava/lang/Long;Lp9/l;)V", ContentDisposition.Parameters.FileName, "Lio/ktor/http/ContentType;", "contentType", "(Lio/ktor/client/request/forms/FormBuilder;Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/ContentType;Ljava/lang/Long;Lp9/l;)V", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FormDslKt {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: io.ktor.client.request.forms.FormDslKt$append$1, reason: invalid class name */
    public static final class AnonymousClass1 implements InterfaceC5063a<v> {
        final /* synthetic */ InterfaceC5074l<s, t> $bodyBuilder;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC5074l<? super s, t> interfaceC5074l) {
            this.$bodyBuilder = interfaceC5074l;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p9.InterfaceC5063a
        public final v invoke() {
            InterfaceC5074l<s, t> interfaceC5074l = this.$bodyBuilder;
            C4074a c4074a = new C4074a();
            interfaceC5074l.invoke(c4074a);
            return c4074a;
        }
    }

    public static final void append(FormBuilder formBuilder, String key, Headers headers, Long l10, InterfaceC5074l<? super s, t> bodyBuilder) {
        p.i(formBuilder, "<this>");
        p.i(key, "key");
        p.i(headers, "headers");
        p.i(bodyBuilder, "bodyBuilder");
        formBuilder.append(new FormPart(key, new InputProvider(l10, new AnonymousClass1(bodyBuilder)), headers));
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String key, Headers headers, Long l10, InterfaceC5074l bodyBuilder, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            headers = Headers.INSTANCE.getEmpty();
        }
        if ((i10 & 4) != 0) {
            l10 = null;
        }
        p.i(formBuilder, "<this>");
        p.i(key, "key");
        p.i(headers, "headers");
        p.i(bodyBuilder, "bodyBuilder");
        formBuilder.append(new FormPart(key, new InputProvider(l10, new AnonymousClass1(bodyBuilder)), headers));
    }

    public static final List<PartData> formData(FormPart<?>... values) {
        PartData binaryChannelItem;
        p.i(values, "values");
        ArrayList arrayList = new ArrayList();
        for (FormPart<?> formPart : values) {
            String key = formPart.getKey();
            final Object objComponent2 = formPart.component2();
            Headers headers = formPart.getHeaders();
            HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
            HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
            headersBuilder.append(httpHeaders.getContentDisposition(), "form-data; name=" + HeaderValueWithParametersKt.escapeIfNeeded(key));
            headersBuilder.appendAll(headers);
            if (objComponent2 instanceof String) {
                binaryChannelItem = new PartData.FormItem((String) objComponent2, new InterfaceC5063a() { // from class: io.ktor.client.request.forms.c
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return t.f7040a;
                    }
                }, headersBuilder.build());
            } else if (objComponent2 instanceof Number) {
                binaryChannelItem = new PartData.FormItem(objComponent2.toString(), new InterfaceC5063a() { // from class: io.ktor.client.request.forms.d
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return t.f7040a;
                    }
                }, headersBuilder.build());
            } else if (objComponent2 instanceof Boolean) {
                binaryChannelItem = new PartData.FormItem(String.valueOf(((Boolean) objComponent2).booleanValue()), new InterfaceC5063a() { // from class: io.ktor.client.request.forms.e
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return t.f7040a;
                    }
                }, headersBuilder.build());
            } else if (objComponent2 instanceof byte[]) {
                headersBuilder.append(httpHeaders.getContentLength(), String.valueOf(((byte[]) objComponent2).length));
                binaryChannelItem = new PartData.BinaryItem(new InterfaceC5063a() { // from class: io.ktor.client.request.forms.f
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return FormDslKt.formData$lambda$9$lambda$4(objComponent2);
                    }
                }, new InterfaceC5063a() { // from class: io.ktor.client.request.forms.g
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return t.f7040a;
                    }
                }, headersBuilder.build());
            } else if (objComponent2 instanceof v) {
                if (objComponent2 instanceof C4074a) {
                    headersBuilder.append(httpHeaders.getContentLength(), String.valueOf(ByteReadPacketKt.getRemaining((v) objComponent2)));
                }
                binaryChannelItem = new PartData.BinaryItem(new InterfaceC5063a() { // from class: io.ktor.client.request.forms.h
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return FormDslKt.formData$lambda$9$lambda$6(objComponent2);
                    }
                }, new InterfaceC5063a() { // from class: io.ktor.client.request.forms.i
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return FormDslKt.formData$lambda$9$lambda$7(objComponent2);
                    }
                }, headersBuilder.build());
            } else if (objComponent2 instanceof InputProvider) {
                InputProvider inputProvider = (InputProvider) objComponent2;
                Long size = inputProvider.getSize();
                if (size != null) {
                    headersBuilder.append(httpHeaders.getContentLength(), size.toString());
                }
                binaryChannelItem = new PartData.BinaryItem(inputProvider.getBlock(), new InterfaceC5063a() { // from class: io.ktor.client.request.forms.j
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return t.f7040a;
                    }
                }, headersBuilder.build());
            } else {
                if (!(objComponent2 instanceof ChannelProvider)) {
                    throw new IllegalStateException(("Unknown form content type: " + objComponent2).toString());
                }
                ChannelProvider channelProvider = (ChannelProvider) objComponent2;
                Long size2 = channelProvider.getSize();
                if (size2 != null) {
                    headersBuilder.append(httpHeaders.getContentLength(), size2.toString());
                }
                binaryChannelItem = new PartData.BinaryChannelItem(channelProvider.getBlock(), headersBuilder.build());
            }
            arrayList.add(binaryChannelItem);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v formData$lambda$9$lambda$4(Object obj) {
        return ByteReadPacketKt.ByteReadPacket$default((byte[]) obj, 0, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v formData$lambda$9$lambda$6(Object obj) {
        return ((v) obj).peek();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t formData$lambda$9$lambda$7(Object obj) {
        ((v) obj).close();
        return t.f7040a;
    }

    public static final void append(FormBuilder formBuilder, String key, String filename, ContentType contentType, Long l10, InterfaceC5074l<? super s, t> bodyBuilder) {
        p.i(formBuilder, "<this>");
        p.i(key, "key");
        p.i(filename, "filename");
        p.i(bodyBuilder, "bodyBuilder");
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        headersBuilder.set(httpHeaders.getContentDisposition(), "filename=" + HeaderValueWithParametersKt.escapeIfNeeded(filename));
        if (contentType != null) {
            headersBuilder.set(httpHeaders.getContentType(), contentType.toString());
        }
        formBuilder.append(new FormPart(key, new InputProvider(l10, new AnonymousClass1(bodyBuilder)), headersBuilder.build()));
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, String str2, ContentType contentType, Long l10, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            contentType = null;
        }
        if ((i10 & 8) != 0) {
            l10 = null;
        }
        append(formBuilder, str, str2, contentType, l10, interfaceC5074l);
    }

    public static final List<PartData> formData(InterfaceC5074l<? super FormBuilder, t> block) {
        p.i(block, "block");
        FormBuilder formBuilder = new FormBuilder();
        block.invoke(formBuilder);
        FormPart[] formPartArr = (FormPart[]) formBuilder.build$ktor_client_core().toArray(new FormPart[0]);
        return formData((FormPart<?>[]) Arrays.copyOf(formPartArr, formPartArr.length));
    }
}
