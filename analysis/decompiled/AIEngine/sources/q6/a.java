package q6;

import com.stepos.base.awareness.data.SceneType;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface a {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: q6.a$a, reason: collision with other inner class name */
    public interface InterfaceC0129a {
        void a();
    }

    void addSceneChangeListener(InterfaceC0129a interfaceC0129a);

    SceneType getCurrentScene();

    r6.a getScheduleDecision();

    r6.b getSystemLoad();

    void refreshScene();

    void removeSceneChangeListener(InterfaceC0129a interfaceC0129a);
}
