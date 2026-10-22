package com.bytedance.android.openlive.customize;

import com.bytedance.android.livesdkapi.customize.ICustomizeTool;
import com.bytedance.android.livesdkapi.customize.IFollowTool;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/openlive/customize/CustomizeTool;", "Lcom/bytedance/android/livesdkapi/customize/ICustomizeTool;", "()V", "followTool", "Lcom/bytedance/android/livesdkapi/customize/IFollowTool;", "live-inner-host-integration-default_release"}, k = 1, mv = {1, 4, 3})
public final class CustomizeTool implements ICustomizeTool {
    @Override // com.bytedance.android.livesdkapi.customize.ICustomizeTool
    public IFollowTool followTool() {
        return (IFollowTool) k.n(IFollowTool.class);
    }

    public CustomizeTool() {
        k.l(ICustomizeTool.class, this);
    }
}
