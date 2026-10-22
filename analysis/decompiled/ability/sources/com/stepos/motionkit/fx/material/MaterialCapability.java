package com.stepos.motionkit.fx.material;

import android.content.Context;
import android.view.View;
import com.stepos.motionkit.fx.material.MaterialParams;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\r\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u001f\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0013R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/stepos/motionkit/fx/material/MaterialCapability;", "P", "Lcom/stepos/motionkit/fx/material/MaterialParams;", "", "id", "", "getId", "()Ljava/lang/String;", "defaultParams", "()Lcom/stepos/motionkit/fx/material/MaterialParams;", "isSupported", "", "context", "Landroid/content/Context;", "bind", "Lcom/stepos/motionkit/fx/material/MaterialBinding;", "view", "Landroid/view/View;", "params", "(Landroid/view/View;Lcom/stepos/motionkit/fx/material/MaterialParams;)Lcom/stepos/motionkit/fx/material/MaterialBinding;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface MaterialCapability<P extends MaterialParams> {
    MaterialBinding bind(View view, P params);

    P defaultParams();

    String getId();

    boolean isSupported(Context context);
}
