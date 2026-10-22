package by7;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.ixigua.lib.track.TrackParams;

/* JADX INFO: loaded from: classes3.dex */
public interface e extends d {

    /* JADX INFO: loaded from: classes23.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static e a(e r100) {
            if ((r100 instanceof Activity) == false) goto L8;
            Intent r101 = ((Activity) r100).getIntent();
            if (r101 != null) goto L17;
            return null;
        L17:
            return h.c(r101);
        L8:
            if ((r100 instanceof Fragment) == false) goto L11;
            return h.d((Fragment) r100);
        L11:
            if ((r100 instanceof e) == false) goto L19;
            e r102 = r100.parentTrackNode();
            if (r102 != null) goto L15;
            return null;
        L15:
            return r102.referrerTrackNode();
        L19:
            return null;
        }
    }

    @Override // by7.d
    void fillTrackParams(TrackParams r100);

    e parentTrackNode();

    e referrerTrackNode();
}
