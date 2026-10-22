package com.bytedance.als.ui.group;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.als.LogicComponent;
import com.bytedance.als.b;
import com.bytedance.objectcontainer.InjectAware;
import com.bytedance.objectcontainer.ObjectContainer;
import com.bytedance.scene.group.GroupScene;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u00012\u00020\u00042\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/als/ui/group/UIGroupLogicComponent;", "Lcom/bytedance/als/b;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/als/LogicComponent;", "Lcom/bytedance/objectcontainer/InjectAware;", "", "als_release"}, k = 1, mv = {1, 4, 1})
public abstract class UIGroupLogicComponent<T extends b> extends LogicComponent<T> implements b, InjectAware {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GroupScene f38102c;

    @Override // com.bytedance.objectcontainer.InjectAware
    public final ObjectContainer a() {
        return null;
    }

    @Override // com.bytedance.als.LogicComponent
    public final T i() {
        return null;
    }

    @Override // com.bytedance.als.LogicComponent
    public final void onCreate() {
        super.onCreate();
        throw null;
    }

    @Override // com.bytedance.als.LogicComponent
    public final void onDestroy() {
        super.onDestroy();
    }
}
