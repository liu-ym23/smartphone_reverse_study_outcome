package org.tukaani.xz;

/* JADX INFO: loaded from: classes3.dex */
interface FilterEncoder extends FilterCoder {
    long getFilterID();

    byte[] getFilterProps();

    FinishableOutputStream getOutputStream(FinishableOutputStream r1, ArrayCache r2);

    boolean supportsFlushing();
}
