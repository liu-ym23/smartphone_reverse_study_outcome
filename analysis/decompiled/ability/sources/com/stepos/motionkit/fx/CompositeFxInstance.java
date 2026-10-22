package com.stepos.motionkit.fx;

import D7.v;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.FxInstance;
import com.stepos.motionkit.InternalFxInstance;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import m5.a;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0017J/\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0019J7\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\tH\u0016¢\u0006\u0004\b$\u0010\u001eJ\u0019\u0010%\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b%\u0010&R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010'R\u001a\u0010(\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010\u0011\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010,\u001a\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/stepos/motionkit/fx/CompositeFxInstance;", "Lcom/stepos/motionkit/InternalFxInstance;", "", "Lcom/stepos/motionkit/FxInstance;", "children", AppAgent.CONSTRUCT, "(Ljava/util/List;)V", "", "elapsedMs", "", "dt", "LC7/r;", "onFrame", "(JF)V", "release", "()V", "", HintConstants.AUTOFILL_HINT_NAME, "value", "setUniform", "(Ljava/lang/String;F)V", "x", "y", "(Ljava/lang/String;FF)V", "z", "(Ljava/lang/String;FFF)V", "w", "(Ljava/lang/String;FFFF)V", "speed", "setSpeed", "(F)V", "", "fps", "setFrameRate", "(I)V", "t", "setProgress", "instance", "(Ljava/lang/String;)Lcom/stepos/motionkit/FxInstance;", "Ljava/util/List;", "id", "J", "getId", "()J", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "", "isActive", "()Z", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CompositeFxInstance implements InternalFxInstance {
    private final List<FxInstance> children;
    private final long id;
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeFxInstance(List<? extends FxInstance> children) {
        k.f(children, "children");
        this.children = children;
        this.id = System.nanoTime();
        this.name = v.I0(children, "+", null, null, new a(10), 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence name$lambda$0(FxInstance it) {
        k.f(it, "it");
        return it.getName();
    }

    @Override // com.stepos.motionkit.FxInstance
    public long getId() {
        return this.id;
    }

    @Override // com.stepos.motionkit.FxInstance
    public String getName() {
        return this.name;
    }

    @Override // com.stepos.motionkit.FxInstance
    public FxInstance instance(String name) {
        Object next;
        k.f(name, "name");
        Iterator<T> it = this.children.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (k.b(((FxInstance) next).getName(), name)) {
                break;
            }
        }
        return (FxInstance) next;
    }

    @Override // com.stepos.motionkit.FxInstance
    public boolean isActive() {
        List<FxInstance> list = this.children;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((FxInstance) it.next()).isActive()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.stepos.motionkit.InternalFxInstance
    public void onFrame(long elapsedMs, float dt) {
        List<FxInstance> list = this.children;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof InternalFxInstance) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InternalFxInstance) it.next()).onFrame(elapsedMs, dt);
        }
    }

    @Override // com.stepos.motionkit.FxInstance
    public void release() {
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            ((FxInstance) it.next()).release();
        }
    }

    @Override // com.stepos.motionkit.FxInstance
    public void setFrameRate(int fps) {
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            ((FxInstance) it.next()).setFrameRate(fps);
        }
    }

    @Override // com.stepos.motionkit.FxInstance
    public void setProgress(float t9) {
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            ((FxInstance) it.next()).setProgress(t9);
        }
    }

    @Override // com.stepos.motionkit.FxInstance
    public void setSpeed(float speed) {
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            ((FxInstance) it.next()).setSpeed(speed);
        }
    }

    @Override // com.stepos.motionkit.FxInstance
    public void setUniform(String name, float value) {
        k.f(name, "name");
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            ((FxInstance) it.next()).setUniform(name, value);
        }
    }

    @Override // com.stepos.motionkit.FxInstance
    public void setUniform(String name, float x10, float y) {
        k.f(name, "name");
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            ((FxInstance) it.next()).setUniform(name, x10, y);
        }
    }

    @Override // com.stepos.motionkit.FxInstance
    public void setUniform(String name, float x10, float y, float z10) {
        k.f(name, "name");
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            ((FxInstance) it.next()).setUniform(name, x10, y, z10);
        }
    }

    @Override // com.stepos.motionkit.FxInstance
    public void setUniform(String name, float x10, float y, float z10, float w8) {
        k.f(name, "name");
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            ((FxInstance) it.next()).setUniform(name, x10, y, z10, w8);
        }
    }
}
