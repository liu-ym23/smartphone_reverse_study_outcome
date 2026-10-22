package com.stepos.ailauncher.chat.manager;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\bJ%\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/X;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "viewer", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;)V", "c", "", "finishing", "changingConfigurations", Const.INTENT_KEY_UMID, "(Ljava/lang/Object;ZZ)Z", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;Z)Z", "", "active", "Ljava/util/Set;", "visible", "", "recreating", "I", "abandoned", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class X<T> {
    private boolean abandoned;
    private int recreating;
    private final Set<T> active = new LinkedHashSet();
    private final Set<T> visible = new LinkedHashSet();

    public final void a(T viewer) {
        int i10;
        if (this.active.add(viewer) && (i10 = this.recreating) > 0) {
            this.recreating = i10 - 1;
        }
        this.visible.add(viewer);
    }

    public final boolean b(T viewer, boolean changingConfigurations) {
        if (!this.active.remove(viewer)) {
            return false;
        }
        this.visible.remove(viewer);
        if (changingConfigurations) {
            this.recreating++;
        }
        return !this.abandoned && this.active.isEmpty() && this.recreating == 0;
    }

    public final void c(T viewer) {
        if (this.active.contains(viewer)) {
            this.visible.add(viewer);
        }
    }

    public final boolean d(T viewer, boolean finishing, boolean changingConfigurations) {
        if (this.active.contains(viewer) && !this.abandoned) {
            this.visible.remove(viewer);
            if (!finishing && !changingConfigurations && this.visible.isEmpty() && this.recreating <= 0) {
                this.abandoned = true;
                return true;
            }
        }
        return false;
    }
}
