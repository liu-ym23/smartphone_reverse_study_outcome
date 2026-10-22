package io.ktor.server.http.content;

import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.http.content.OutgoingContent;
import java.net.URL;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/server/http/content/CompressedResource;", "", "Ljava/net/URL;", "url", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lio/ktor/server/http/content/CompressedFileType;", "compression", "<init>", "(Ljava/net/URL;Lio/ktor/http/content/OutgoingContent$ReadChannelContent;Lio/ktor/server/http/content/CompressedFileType;)V", "Ljava/net/URL;", "getUrl", "()Ljava/net/URL;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "getContent", "()Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Lio/ktor/server/http/content/CompressedFileType;", "getCompression", "()Lio/ktor/server/http/content/CompressedFileType;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CompressedResource {
    private final CompressedFileType compression;
    private final OutgoingContent.ReadChannelContent content;
    private final URL url;

    public CompressedResource(URL url, OutgoingContent.ReadChannelContent content, CompressedFileType compression) {
        kotlin.jvm.internal.p.i(url, "url");
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(compression, "compression");
        this.url = url;
        this.content = content;
        this.compression = compression;
    }

    public final CompressedFileType getCompression() {
        return this.compression;
    }

    public final OutgoingContent.ReadChannelContent getContent() {
        return this.content;
    }

    public final URL getUrl() {
        return this.url;
    }
}
