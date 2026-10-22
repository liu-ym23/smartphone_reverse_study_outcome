package com.byted.cast.mediacommon.model;

/* JADX INFO: loaded from: classes39.dex */
public class NALBitstream {
    private int m_bits;
    private byte m_byte;
    private byte[] m_data;
    private int m_idx;
    private int m_len;
    private int m_zeros;

    public class vc_params_t {
        int height;
        int level;
        int nal_length_size;
        int profile;
        final /* synthetic */ NALBitstream this$0;
        int width;

        private vc_params_t(NALBitstream r100) {
            this.this$0 = r100;
        }
    }

    public int GetUE() {
        int r100 = 0;
    L4:
        if (this.m_idx >= this.m_len) goto L9;
        if (GetBit() != 0) goto L9;
        r100 = r100 + 1;
    L9:
        return GetWord(r100) + ((1 << r100) - 1);
    }

    public byte GetBYTE() {
        int r100 = this.m_idx;
        int r101 = this.m_len;
        if (r100 < r101) goto L5;
        return 0;
    L5:
        byte[] r102 = this.m_data;
        int r103 = r100 + 1;
        this.m_idx = r103;
        byte r104 = r102[r100];
        if (r104 != 0) goto L14;
        int r105 = this.m_zeros + 1;
        this.m_zeros = r105;
        if (r103 < r101) goto L10;
    L15:
        return r104;
    L10:
        if (r105 != 2) goto L15;
        if (r102[r103] != 3) goto L15;
        this.m_idx = r103 + 1;
        this.m_zeros = 0;
        goto L15
    L14:
        this.m_zeros = 0;
        goto L15
    }

    public int GetBit() {
        if (this.m_bits != 0) goto L5;
        this.m_byte = GetBYTE();
        this.m_bits = 8;
    L5:
        int r100 = this.m_bits - 1;
        this.m_bits = r100;
        return (this.m_byte >> r100) & 1;
    }

    public int GetSE() {
        int r100 = GetUE();
        if ((r100 & 1) != 1) goto L5;
        boolean r101 = true;
    L6:
        int r102 = (r100 + 1) >> 1;
        if (r101 == false) goto L9;
        return r102;
    L9:
        return -r102;
    L5:
        r101 = false;
        goto L6
    }

    public int GetWord(int r100) {
        int r101 = 0;
    L3:
        if (r100 <= 0) goto L5;
        r101 = (r101 << 1) | GetBit();
        r100 = r100 - 1;
        goto L3
    L5:
        return r101;
    }

    public NALBitstream(byte[] r100, int r101) {
        Init(r100, r101);
    }

    private void Init(byte[] r100, int r101) {
        this.m_data = r100;
        this.m_len = r100.length;
        this.m_idx = r101;
        this.m_bits = 0;
        this.m_byte = 0;
        this.m_zeros = 0;
    }
}
