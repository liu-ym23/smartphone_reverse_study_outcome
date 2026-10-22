package com.alibaba.gaiax.template.animation;

import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.context.GXTemplateContext;
import com.alibaba.gaiax.render.node.GXNode;
import com.alibaba.gaiax.template.GXIExpression;
import com.alibaba.gaiax.template.factory.GXExpressionFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXLottieAnimation;", "Lcom/alibaba/gaiax/template/animation/GXIAnimation;", "()V", "gxLocalUri", "Lcom/alibaba/gaiax/template/GXIExpression;", "getGxLocalUri", "()Lcom/alibaba/gaiax/template/GXIExpression;", "setGxLocalUri", "(Lcom/alibaba/gaiax/template/GXIExpression;)V", "gxRemoteUri", "getGxRemoteUri", "setGxRemoteUri", GXLottieAnimation.KEY_LOOP_COUNT, "", "getLoopCount", "()I", "setLoopCount", "(I)V", "executeAnimation", "", "gxState", "gxAnimationExpression", "gxTemplateContext", "Lcom/alibaba/gaiax/context/GXTemplateContext;", "gxNode", "Lcom/alibaba/gaiax/render/node/GXNode;", "gxTemplateData", "Lorg/json/JSONObject;", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class GXLottieAnimation implements GXIAnimation {
    public static final Companion Companion = null;
    private static final String KEY_LOOP = "loop";
    private static final String KEY_LOOP_COUNT = "loopCount";
    private static final String KEY_URL = "url";
    private static final String KEY_VALUE = "value";
    private GXIExpression gxLocalUri;
    private GXIExpression gxRemoteUri;
    private int loopCount;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXLottieAnimation$Companion;", "", "()V", "KEY_LOOP", "", "KEY_LOOP_COUNT", "KEY_URL", "KEY_VALUE", "create", "Lcom/alibaba/gaiax/template/animation/GXLottieAnimation;", "expVersion", "data", "Lorg/json/JSONObject;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final GXLottieAnimation create(String r100, JSONObject r101) {
            if (r101 != null) goto L5;
            return null;
        L5:
            String r102 = r101.optString("value", null);
            String r103 = r101.optString("url", null);
            if (r102 != null) goto L9;
            if (r103 != null) goto L9;
            return null;
        L9:
            GXRegisterCenter.GXIExtensionLottieAnimation r104 = GXRegisterCenter.Companion.getInstance().getExtensionLottieAnimation$GaiaX();
            if (r104 == null) goto L27;
            GXLottieAnimation r105 = r104.create();
            if (r105 == null) goto L27;
            if (r102 == null) goto L16;
            r105.setGxLocalUri(GXExpressionFactory.INSTANCE.create(r100, r102));
        L16:
            if (r103 == null) goto L19;
            r105.setGxRemoteUri(GXExpressionFactory.INSTANCE.create(r100, r103));
        L19:
            if (r101.has(GXLottieAnimation.KEY_LOOP) == false) goto L24;
            if (r101.optBoolean(GXLottieAnimation.KEY_LOOP) == false) goto L24;
            r105.setLoopCount(Integer.MAX_VALUE);
        L26:
            return r105;
        L24:
            if (r101.has(GXLottieAnimation.KEY_LOOP_COUNT) == false) goto L26;
            r105.setLoopCount(r101.optInt(GXLottieAnimation.KEY_LOOP_COUNT));
        L27:
            return null;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public GXLottieAnimation() {
    }

    @Override // com.alibaba.gaiax.template.animation.GXIAnimation
    public void executeAnimation(GXIExpression r100, GXIExpression r101, GXTemplateContext r102, GXNode r103, JSONObject r104) {
        Intrinsics.checkNotNullParameter(r102, "gxTemplateContext");
        Intrinsics.checkNotNullParameter(r103, "gxNode");
        Intrinsics.checkNotNullParameter(r104, "gxTemplateData");
    }

    public final GXIExpression getGxLocalUri() {
        return this.gxLocalUri;
    }

    public final GXIExpression getGxRemoteUri() {
        return this.gxRemoteUri;
    }

    public final int getLoopCount() {
        return this.loopCount;
    }

    public final void setGxLocalUri(GXIExpression r100) {
        this.gxLocalUri = r100;
    }

    public final void setGxRemoteUri(GXIExpression r100) {
        this.gxRemoteUri = r100;
    }

    public final void setLoopCount(int r100) {
        this.loopCount = r100;
    }
}
