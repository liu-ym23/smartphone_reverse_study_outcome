package com.bytedance.android.gamecp.host_api.model;

import com.bytedance.android.gamecp.host_api.model.toolbar.GameUnionType;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes44.dex */
@IgnoreProtoFieldCheck
@ProtoMessage("webcast.gamecp.api.SimpleGameInfo")
public final class k extends j {
    public k(am3.g r100) {
        this.tags = new ArrayList();
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        switch(r103) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L6;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L6;
            case 12: goto L6;
            case 13: goto L7;
            default: goto L6;
        };
    L7:
        this.userGameStats = am3.h.c(r100);
        goto L3
    L8:
        this.gameTagId = r100.j();
        goto L3
    L9:
        this.gameCategoryId = r100.j();
        goto L3
    L10:
        this.gameUnionType = r100.j();
        r102 = r102 | 2;
        goto L3
    L11:
        this.gameStage = r100.i();
        r102 = r102 | 1;
        goto L3
    L12:
        this.androidPackageName = am3.h.c(r100);
        goto L3
    L13:
        this.androidPackageSize = am3.h.c(r100);
        goto L3
    L14:
        this.tags.add(am3.h.c(r100));
        goto L3
    L15:
        this.name = am3.h.c(r100);
        goto L3
    L16:
        this.gameId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L21;
        this.gameStage = GameStageType.NONE.getType();
    L21:
        if (this.name != null) goto L24;
        this.name = "";
    L24:
        if (this.androidPackageSize != null) goto L27;
        this.androidPackageSize = "";
    L27:
        if (this.tags.isEmpty() == false) goto L30;
        this.tags = new ArrayList();
    L30:
        if (this.androidPackageName != null) goto L33;
        this.androidPackageName = "";
    L33:
        if ((r102 & 2) != 0) goto L60;
        this.gameUnionType = GameUnionType.UNION_GAME.getType();
        return;
    }
}
