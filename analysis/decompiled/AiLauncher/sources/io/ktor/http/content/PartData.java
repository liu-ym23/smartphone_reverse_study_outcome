package io.ktor.http.content;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import fb.v;
import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u001e\u001f !B\u001f\b\u0004\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0082\u0001\u0004\"#$%¨\u0006&"}, d2 = {"Lio/ktor/http/content/PartData;", "", "Lkotlin/Function0;", "LY8/t;", "dispose", "Lio/ktor/http/Headers;", "headers", "<init>", "(Lp9/a;Lio/ktor/http/Headers;)V", "Lp9/a;", "getDispose", "()Lp9/a;", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "Lio/ktor/http/ContentDisposition;", "contentDisposition$delegate", "LY8/h;", "getContentDisposition", "()Lio/ktor/http/ContentDisposition;", "contentDisposition", "Lio/ktor/http/ContentType;", "contentType$delegate", "getContentType", "()Lio/ktor/http/ContentType;", "contentType", "", "getName", "()Ljava/lang/String;", "name", "FormItem", "FileItem", "BinaryItem", "BinaryChannelItem", "Lio/ktor/http/content/PartData$BinaryChannelItem;", "Lio/ktor/http/content/PartData$BinaryItem;", "Lio/ktor/http/content/PartData$FileItem;", "Lio/ktor/http/content/PartData$FormItem;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class PartData {

    /* renamed from: contentDisposition$delegate, reason: from kotlin metadata */
    private final Y8.h contentDisposition;

    /* renamed from: contentType$delegate, reason: from kotlin metadata */
    private final Y8.h contentType;
    private final InterfaceC5063a<t> dispose;
    private final Headers headers;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/http/content/PartData$BinaryChannelItem;", "Lio/ktor/http/content/PartData;", "Lkotlin/Function0;", "Lio/ktor/utils/io/ByteReadChannel;", Const.JSON_KEY_PROVIDER, "Lio/ktor/http/Headers;", "partHeaders", "<init>", "(Lp9/a;Lio/ktor/http/Headers;)V", "Lp9/a;", "getProvider", "()Lp9/a;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class BinaryChannelItem extends PartData {
        private final InterfaceC5063a<ByteReadChannel> provider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public BinaryChannelItem(InterfaceC5063a<? extends ByteReadChannel> provider, Headers partHeaders) {
            super(new InterfaceC5063a() { // from class: io.ktor.http.content.k
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return t.f7040a;
                }
            }, partHeaders, null);
            p.i(provider, "provider");
            p.i(partHeaders, "partHeaders");
            this.provider = provider;
        }

        public final InterfaceC5063a<ByteReadChannel> getProvider() {
            return this.provider;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR!\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/http/content/PartData$BinaryItem;", "Lio/ktor/http/content/PartData;", "Lkotlin/Function0;", "Lfb/v;", "Lio/ktor/utils/io/core/Input;", Const.JSON_KEY_PROVIDER, "LY8/t;", "dispose", "Lio/ktor/http/Headers;", "partHeaders", "<init>", "(Lp9/a;Lp9/a;Lio/ktor/http/Headers;)V", "Lp9/a;", "getProvider", "()Lp9/a;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class BinaryItem extends PartData {
        private final InterfaceC5063a<v> provider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public BinaryItem(InterfaceC5063a<? extends v> provider, InterfaceC5063a<t> dispose, Headers partHeaders) {
            super(dispose, partHeaders, null);
            p.i(provider, "provider");
            p.i(dispose, "dispose");
            p.i(partHeaders, "partHeaders");
            this.provider = provider;
        }

        public final InterfaceC5063a<v> getProvider() {
            return this.provider;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/http/content/PartData$FileItem;", "Lio/ktor/http/content/PartData;", "Lkotlin/Function0;", "Lio/ktor/utils/io/ByteReadChannel;", Const.JSON_KEY_PROVIDER, "LY8/t;", "dispose", "Lio/ktor/http/Headers;", "partHeaders", "<init>", "(Lp9/a;Lp9/a;Lio/ktor/http/Headers;)V", "Lp9/a;", "getProvider", "()Lp9/a;", "", "originalFileName", "Ljava/lang/String;", "getOriginalFileName", "()Ljava/lang/String;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class FileItem extends PartData {
        private final String originalFileName;
        private final InterfaceC5063a<ByteReadChannel> provider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public FileItem(InterfaceC5063a<? extends ByteReadChannel> provider, InterfaceC5063a<t> dispose, Headers partHeaders) {
            super(dispose, partHeaders, 0 == true ? 1 : 0);
            p.i(provider, "provider");
            p.i(dispose, "dispose");
            p.i(partHeaders, "partHeaders");
            this.provider = provider;
            ContentDisposition contentDisposition = getContentDisposition();
            this.originalFileName = contentDisposition != null ? contentDisposition.parameter(ContentDisposition.Parameters.FileName) : null;
        }

        public final String getOriginalFileName() {
            return this.originalFileName;
        }

        public final InterfaceC5063a<ByteReadChannel> getProvider() {
            return this.provider;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/http/content/PartData$FormItem;", "Lio/ktor/http/content/PartData;", "", UxipConstants.f30680s, "Lkotlin/Function0;", "LY8/t;", "dispose", "Lio/ktor/http/Headers;", "partHeaders", "<init>", "(Ljava/lang/String;Lp9/a;Lio/ktor/http/Headers;)V", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class FormItem extends PartData {
        private final String value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FormItem(String value, InterfaceC5063a<t> dispose, Headers partHeaders) {
            super(dispose, partHeaders, null);
            p.i(value, "value");
            p.i(dispose, "dispose");
            p.i(partHeaders, "partHeaders");
            this.value = value;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public /* synthetic */ PartData(InterfaceC5063a interfaceC5063a, Headers headers, kotlin.jvm.internal.i iVar) {
        this(interfaceC5063a, headers);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentDisposition contentDisposition_delegate$lambda$1(PartData partData) {
        String str = partData.headers.get(HttpHeaders.INSTANCE.getContentDisposition());
        if (str != null) {
            return ContentDisposition.INSTANCE.parse(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentType contentType_delegate$lambda$3(PartData partData) {
        String str = partData.headers.get(HttpHeaders.INSTANCE.getContentType());
        if (str != null) {
            return ContentType.INSTANCE.parse(str);
        }
        return null;
    }

    public final ContentDisposition getContentDisposition() {
        return (ContentDisposition) this.contentDisposition.getValue();
    }

    public final ContentType getContentType() {
        return (ContentType) this.contentType.getValue();
    }

    public final InterfaceC5063a<t> getDispose() {
        return this.dispose;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final String getName() {
        ContentDisposition contentDisposition = getContentDisposition();
        if (contentDisposition != null) {
            return contentDisposition.getName();
        }
        return null;
    }

    private PartData(InterfaceC5063a<t> interfaceC5063a, Headers headers) {
        this.dispose = interfaceC5063a;
        this.headers = headers;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.contentDisposition = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: io.ktor.http.content.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return PartData.contentDisposition_delegate$lambda$1(this.f33306a);
            }
        });
        this.contentType = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: io.ktor.http.content.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return PartData.contentType_delegate$lambda$3(this.f33307a);
            }
        });
    }
}
