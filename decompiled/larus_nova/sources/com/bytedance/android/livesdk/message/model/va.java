package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.message.IRtcRoomMessage;
import com.bytedance.android.livesdkapi.message.Text;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface va extends com.bytedance.android.live.base.model.message.t, com.bytedance.android.live.base.model.message.u3, IRtcRoomMessage {

    public interface a {
        long a();

        boolean b();

        void c(py.k r100);

        void d(int r100);

        void e(long r100);

        List<py.k> f();

        void g(long r100);

        long getAlignment();

        long getAlignmentOffset();

        long getAnimAssetId();

        py.k getAnimatedBadge();

        int getAvatarPos();

        long getCenterAnimAssetId();

        String getDressId();

        py.k getDynamicImage();

        Map<String, String> getExtra();

        py.k getIcon();

        int getStayTime();

        com.bytedance.android.live.base.model.message.a5 getText();

        py.k getTextIcon();

        py.k getTextIconOverlay();

        int getType();

        void h(long r100);

        void i(py.k r100);

        void j(long r100);

        void k(py.k r100);

        Map<String, ? extends com.bytedance.android.live.base.model.message.c5> l();

        void m(long r100);

        void setIcon(py.k r100);

        void setType(int r100);
    }

    String F0();

    Text F1();

    long Z0();

    long a0();

    int e();

    long getAction();

    String getActionContent();

    py.k getBackground();

    Map<String, String> getBuriedPoint();

    @Override // com.bytedance.android.live.base.model.message.t
    long getTimestamp();

    IBaseUser getUser();

    long j0();

    MemberMessage.b r();

    long z1();
}
