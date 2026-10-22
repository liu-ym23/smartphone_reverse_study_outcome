package b17;

import com.bytedance.lynx.tasm.ui.imageloader.InlineImageShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode;

/* JADX INFO: loaded from: classes21.dex */
public final class e extends com.lynx.tasm.behavior.a {
    public e() {
        super("inline-image", false, true);
    }

    @Override // com.lynx.tasm.behavior.a
    public final ShadowNode createShadowNode() {
        return new InlineImageShadowNode();
    }
}
