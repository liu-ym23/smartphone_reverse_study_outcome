package com.bytedance.android.livesdk.ktvimpl.chorus;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR'\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/chorus/ChorusContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "getChorusNotSelfSeeingMusicList", "Lcom/bytedance/live/datacontext/j;", "Lfd2/f;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/android/livesdk/ktvimpl/chorus/ChorusViewModel;", "chorusViewModel$delegate", "getChorusViewModel", "chorusViewModel", "Lcom/bytedance/live/datacontext/n;", "chorusSelectedSongList$delegate", "getChorusSelectedSongList", "()Lcom/bytedance/live/datacontext/n;", "chorusSelectedSongList", "", "chorusOpenStatus$delegate", "getChorusOpenStatus", "chorusOpenStatus", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChorusContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p chorusOpenStatus$delegate;
    private final p chorusSelectedSongList$delegate;
    private final p chorusViewModel$delegate;
    private final p service$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final ChorusContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(ChorusContext.class);
            if ((r100 instanceof ChorusContext) == true) goto L6;
            r100 = null;
        L6:
            return (ChorusContext) r100;
        }

        public final int a() {
            ChorusContext r100 = getContext();
            if (r100 == null) goto L9;
            j<fd2.f> r101 = r100.getService();
            if (r101 == null) goto L9;
            fd2.f r102 = r101.getValue();
            if (r102 == null) goto L9;
            return r102.i0();
        L9:
            return 0;
        }

        public final fd2.f b() {
            ChorusContext r100 = getContext();
            if (r100 == null) goto L7;
            j<fd2.f> r101 = r100.getService();
            if (r101 == null) goto L7;
            return r101.getValue();
        L7:
            return null;
        }

        public final boolean c() {
            fd2.f r100 = b();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.Pp();
        }

        public final boolean d() {
            if (a() == 1) goto L7;
            return false;
        L7:
            return true;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ChorusContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ChorusContext.class, "chorusViewModel", "getChorusViewModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ChorusContext.class, "chorusSelectedSongList", "getChorusSelectedSongList()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ChorusContext.class, "chorusOpenStatus", "getChorusOpenStatus()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final ChorusContext getContext() {
        return Companion.getContext();
    }

    public final n<Boolean> getChorusOpenStatus() {
        return (n) this.chorusOpenStatus$delegate.a(this, $$delegatedProperties[3]);
    }

    public final n<List<MusicPanel>> getChorusSelectedSongList() {
        return (n) this.chorusSelectedSongList$delegate.a(this, $$delegatedProperties[2]);
    }

    public final j<ChorusViewModel> getChorusViewModel() {
        return (j) this.chorusViewModel$delegate.a(this, $$delegatedProperties[1]);
    }

    public final j<fd2.f> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public ChorusContext() {
        this.service$delegate = ConstantKt.c(this);
        this.chorusViewModel$delegate = ConstantKt.c(this);
        this.chorusSelectedSongList$delegate = q.c(this);
        this.chorusOpenStatus$delegate = q.c(this);
    }

    public final List<MusicPanel> getChorusNotSelfSeeingMusicList() {
        List<MusicPanel> r100 = getChorusSelectedSongList().getValue();
        if (r100 == null) goto L11;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L17;
        Object r103 = r102.next();
        if (((MusicPanel) r103).f153581e == true) goto L6;
        r101.add(r103);
        goto L6
    L17:
        return r101;
    L11:
        return new ArrayList();
    }
}
