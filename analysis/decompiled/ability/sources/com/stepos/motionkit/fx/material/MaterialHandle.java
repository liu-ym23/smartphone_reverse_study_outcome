package com.stepos.motionkit.fx.material;

import C7.r;
import D6.i;
import D7.w;
import android.view.View;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.backend.CrossWindowMaterialBackend;
import com.stepos.motionkit.fx.material.backend.InWindowMaterialBackend;
import com.stepos.motionkit.fx.material.capability.GlassTextBinding;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00012B'\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0010J!\u0010\u0019\u001a\u00020\u000e2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000e0\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\"\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0011¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u000e¢\u0006\u0004\b$\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010%R\"\u0010(\u001a\u0010\u0012\f\u0012\n '*\u0004\u0018\u00010\u00020\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010*R\u0011\u0010.\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00068F¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/stepos/motionkit/fx/material/MaterialHandle;", "", "Landroid/view/View;", "view", "", "crossWindow", "", "Lcom/stepos/motionkit/fx/material/MaterialHandle$Entry;", "entries", AppAgent.CONSTRUCT, "(Landroid/view/View;ZLjava/util/List;)V", "Lcom/stepos/motionkit/fx/material/capability/GlassTextBinding;", "glassTextBinding", "()Lcom/stepos/motionkit/fx/material/capability/GlassTextBinding;", "LC7/r;", "releaseEntries", "()V", "", "px", "cornerRadius", "(F)V", "refreshGlassText", "Lkotlin/Function1;", "Lcom/stepos/motionkit/fx/material/capability/GlassTextParams;", "block", "glassText", "(LS7/k;)V", "", "text", "setClockText", "(Ljava/lang/String;)V", "", "elapsedMs", "dt", "onFrame", "(JF)V", "release", "Z", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "viewRef", "Ljava/lang/ref/WeakReference;", "Ljava/util/List;", "", "getActiveCount", "()I", "activeCount", "getActiveIds", "()Ljava/util/List;", "activeIds", "Entry", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MaterialHandle {
    private final boolean crossWindow;
    private List<Entry> entries;
    private final WeakReference<View> viewRef;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/motionkit/fx/material/MaterialHandle$Entry;", "", "capabilityId", "", "binding", "Lcom/stepos/motionkit/fx/material/MaterialBinding;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/stepos/motionkit/fx/material/MaterialBinding;)V", "getCapabilityId", "()Ljava/lang/String;", "getBinding", "()Lcom/stepos/motionkit/fx/material/MaterialBinding;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Entry {
        private final MaterialBinding binding;
        private final String capabilityId;

        public Entry(String capabilityId, MaterialBinding binding) {
            k.f(capabilityId, "capabilityId");
            k.f(binding, "binding");
            this.capabilityId = capabilityId;
            this.binding = binding;
        }

        public final MaterialBinding getBinding() {
            return this.binding;
        }

        public final String getCapabilityId() {
            return this.capabilityId;
        }
    }

    public MaterialHandle(View view, boolean z10, List<Entry> entries) {
        k.f(view, "view");
        k.f(entries, "entries");
        this.crossWindow = z10;
        this.viewRef = new WeakReference<>(view);
        this.entries = entries;
    }

    private final GlassTextBinding glassTextBinding() {
        Object next;
        Iterator<T> it = this.entries.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (k.b(((Entry) next).getCapabilityId(), "glass_text")) {
                break;
            }
        }
        Entry entry = (Entry) next;
        MaterialBinding binding = entry != null ? entry.getBinding() : null;
        if (binding instanceof GlassTextBinding) {
            return (GlassTextBinding) binding;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r release$lambda$4(MaterialHandle materialHandle) {
        materialHandle.releaseEntries();
        return r.f317a;
    }

    private final void releaseEntries() {
        Iterator<T> it = this.entries.iterator();
        while (it.hasNext()) {
            try {
                ((Entry) it.next()).getBinding().release();
            } catch (Throwable th) {
                kotlin.b.a(th);
            }
        }
    }

    public final void cornerRadius(float px) {
        View view = this.viewRef.get();
        if (view == null) {
            return;
        }
        if (this.crossWindow) {
            CrossWindowMaterialBackend.INSTANCE.setCornerRadius(view, px);
        } else {
            InWindowMaterialBackend.INSTANCE.setCornerRadius(view, px);
        }
    }

    public final int getActiveCount() {
        return this.entries.size();
    }

    public final List<String> getActiveIds() {
        List<Entry> list = this.entries;
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Entry) it.next()).getCapabilityId());
        }
        return arrayList;
    }

    public final void glassText(S7.k block) throws IllegalArgumentException {
        k.f(block, "block");
        GlassTextBinding glassTextBinding = glassTextBinding();
        if (glassTextBinding != null) {
            glassTextBinding.mergeGlassText(block);
        }
    }

    public final void onFrame(long elapsedMs, float dt) {
        Iterator<T> it = this.entries.iterator();
        while (it.hasNext()) {
            try {
                ((Entry) it.next()).getBinding().onFrame(elapsedMs, dt);
            } catch (Throwable th) {
                kotlin.b.a(th);
            }
        }
    }

    public final void refreshGlassText() throws IllegalArgumentException {
        GlassTextBinding glassTextBinding = glassTextBinding();
        if (glassTextBinding != null) {
            glassTextBinding.refreshGlassText();
        }
    }

    public final void release() {
        if (this.entries.isEmpty()) {
            return;
        }
        if (this.crossWindow) {
            releaseEntries();
        } else {
            InWindowMaterialBackend.INSTANCE.batch(new i(this, 22));
        }
        this.entries = EmptyList.f4893a;
    }

    public final void setClockText(String text) throws IllegalArgumentException {
        k.f(text, "text");
        GlassTextBinding glassTextBinding = glassTextBinding();
        if (glassTextBinding != null) {
            glassTextBinding.setClockText(text);
        }
    }
}
