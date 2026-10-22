package io.ktor.http.content;

import io.ktor.http.content.PartData;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lio/ktor/http/content/PartData$FileItem;", "Lkotlin/Function0;", "Ljava/io/InputStream;", "getStreamProvider", "(Lio/ktor/http/content/PartData$FileItem;)Lp9/a;", "getStreamProvider$annotations", "(Lio/ktor/http/content/PartData$FileItem;)V", "streamProvider", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MultipartJvmKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final InputStream _get_streamProvider_$lambda$0(PartData.FileItem fileItem) {
        return BlockingKt.toInputStream$default(fileItem.getProvider().invoke(), null, 1, null);
    }

    public static final InterfaceC5063a<InputStream> getStreamProvider(final PartData.FileItem fileItem) {
        p.i(fileItem, "<this>");
        return new InterfaceC5063a() { // from class: io.ktor.http.content.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MultipartJvmKt._get_streamProvider_$lambda$0(fileItem);
            }
        };
    }

    public static /* synthetic */ void getStreamProvider$annotations(PartData.FileItem fileItem) {
    }
}
