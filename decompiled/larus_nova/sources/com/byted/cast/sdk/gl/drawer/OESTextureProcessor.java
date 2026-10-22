package com.byted.cast.sdk.gl.drawer;

import com.byted.cast.sdk.gl.utils.GLUtils;

/* JADX INFO: loaded from: classes43.dex */
public class OESTextureProcessor extends TextureProcessor {
    @Override // com.byted.cast.sdk.gl.drawer.TextureDrawer
    public int getTextureTarget() {
        return 36197;
    }

    @Override // com.byted.cast.sdk.gl.drawer.TextureDrawer
    public String[] getShaderSources() {
        return new String[]{GLUtils.TEXTURE_VS, GLUtils.TEXTURE_EXTERNAL_FS};
    }

    public OESTextureProcessor(String r100) {
        super(r100);
    }
}
