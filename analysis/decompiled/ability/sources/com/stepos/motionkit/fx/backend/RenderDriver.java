package com.stepos.motionkit.fx.backend;

import io.modelcontextprotocol.spec.McpSchema;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/motionkit/fx/backend/RenderDriver;", "", "Lkotlin/Function0;", "", "isCancelled", McpSchema.METHOD_INITIALIZE, "(LS7/a;)Z", "", "elapsedMs", "LC7/r;", "draw", "(J)V", "release", "()V", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface RenderDriver {
    void draw(long elapsedMs);

    boolean initialize(S7.a isCancelled);

    void release();
}
