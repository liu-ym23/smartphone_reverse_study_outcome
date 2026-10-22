package com.stepos.core.common.net;

import java.util.Arrays;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class HttpBody {
    public /* synthetic */ HttpBody(e eVar) {
        this();
    }

    public abstract String getContentType();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Bytes extends HttpBody {
        private final byte[] content;
        private final String contentType;

        public /* synthetic */ Bytes(byte[] bArr, String str, int i10, e eVar) {
            this(bArr, (i10 & 2) != 0 ? "application/octet-stream" : str);
        }

        public static /* synthetic */ Bytes copy$default(Bytes bytes, byte[] bArr, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                bArr = bytes.content;
            }
            if ((i10 & 2) != 0) {
                str = bytes.contentType;
            }
            return bytes.copy(bArr, str);
        }

        public final byte[] component1() {
            return this.content;
        }

        public final String component2() {
            return this.contentType;
        }

        public final Bytes copy(byte[] content, String contentType) {
            g.f(content, "content");
            g.f(contentType, "contentType");
            return new Bytes(content, contentType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Bytes)) {
                return false;
            }
            Bytes bytes = (Bytes) obj;
            return Arrays.equals(this.content, bytes.content) && g.b(getContentType(), bytes.getContentType());
        }

        public final byte[] getContent() {
            return this.content;
        }

        @Override // com.stepos.core.common.net.HttpBody
        public String getContentType() {
            return this.contentType;
        }

        public int hashCode() {
            return getContentType().hashCode() + (Arrays.hashCode(this.content) * 31);
        }

        public String toString() {
            return h0.e.c("Bytes(content=", Arrays.toString(this.content), ", contentType=", this.contentType, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Bytes(byte[] content, String contentType) {
            super(null);
            g.f(content, "content");
            g.f(contentType, "contentType");
            this.content = content;
            this.contentType = contentType;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Text extends HttpBody {
        private final String content;
        private final String contentType;

        public /* synthetic */ Text(String str, String str2, int i10, e eVar) {
            this(str, (i10 & 2) != 0 ? "application/json; charset=utf-8" : str2);
        }

        public static /* synthetic */ Text copy$default(Text text, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = text.content;
            }
            if ((i10 & 2) != 0) {
                str2 = text.contentType;
            }
            return text.copy(str, str2);
        }

        public final String component1() {
            return this.content;
        }

        public final String component2() {
            return this.contentType;
        }

        public final Text copy(String content, String contentType) {
            g.f(content, "content");
            g.f(contentType, "contentType");
            return new Text(content, contentType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Text)) {
                return false;
            }
            Text text = (Text) obj;
            return g.b(this.content, text.content) && g.b(this.contentType, text.contentType);
        }

        public final String getContent() {
            return this.content;
        }

        @Override // com.stepos.core.common.net.HttpBody
        public String getContentType() {
            return this.contentType;
        }

        public int hashCode() {
            return this.contentType.hashCode() + (this.content.hashCode() * 31);
        }

        public String toString() {
            return h0.e.c("Text(content=", this.content, ", contentType=", this.contentType, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(String content, String contentType) {
            super(null);
            g.f(content, "content");
            g.f(contentType, "contentType");
            this.content = content;
            this.contentType = contentType;
        }
    }

    private HttpBody() {
    }
}
