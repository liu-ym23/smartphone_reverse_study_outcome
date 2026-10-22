package rb;

import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f23844a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f23845b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f23846c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f23847d = null;

    static {
        int[] r10 = new int[AlphaVideoViewType.values().length];
        f23844a = r10;
        r10[AlphaVideoViewType.GL_SURFACE_VIEW.ordinal()] = 1;
        r10[AlphaVideoViewType.GL_TEXTURE_VIEW.ordinal()] = 2;
        int[] r11 = new int[PlayerState.values().length];
        f23845b = r11;
        r11[PlayerState.PREPARED.ordinal()] = 1;
        PlayerState r12 = PlayerState.PAUSED;
        r11[r12.ordinal()] = 2;
        r11[PlayerState.NOT_PREPARED.ordinal()] = 3;
        r11[PlayerState.STOPPED.ordinal()] = 4;
        int[] r13 = new int[PlayerState.values().length];
        f23846c = r13;
        PlayerState r14 = PlayerState.STARTED;
        r13[r14.ordinal()] = 1;
        int[] r15 = new int[PlayerState.values().length];
        f23847d = r15;
        r15[r14.ordinal()] = 1;
        r15[r12.ordinal()] = 2;
    }
}
