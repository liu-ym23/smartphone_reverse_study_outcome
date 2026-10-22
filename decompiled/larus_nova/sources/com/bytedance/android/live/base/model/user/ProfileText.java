package com.bytedance.android.live.base.model.user;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class ProfileText {

    @SerializedName("pieces")
    List<ProfileTextPiece> pieces;

    public ProfileText() {
    }

    public int imagePiecesCount() {
        int r100 = 0;
        if (this.pieces == null) goto L12;
        int r101 = 0;
    L6:
        if (r100 >= this.pieces.size()) goto L11;
        if (((ProfileTextPiece) ListProtector.get(this.pieces, r100)).type != ProfileTextPiece.PIECE_TYPE_IMAGE) goto L10;
        r101 = r101 + 1;
    L10:
        r100 = r100 + 1;
        goto L6
    L11:
        return r101;
    L12:
        return 0;
    }

    public List<ProfileTextPiece> getPieces() {
        return this.pieces;
    }

    public void setPieces(List<ProfileTextPiece> r100) {
        this.pieces = r100;
    }
}
