package com.bytedance.bdinstall;

/* JADX INFO: compiled from: IEncryptor.java */
/* JADX INFO: loaded from: classes.dex */
public interface ad {

    /* JADX INFO: compiled from: IEncryptor.java */
    public static class a implements ad {
        public a() {
        }

        @Override // com.bytedance.bdinstall.ad
        public byte[] a(byte[] r1, int r2) {
            return com.bytedance.frameworks.core.encrypt.b.a(r1, r2);
        L4:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    byte[] a(byte[] r1, int r2);
}
