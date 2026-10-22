package com.byted.cast.proxy.impl;

/* JADX INFO: loaded from: classes39.dex */
public class ByteArrayQueue {
    private int leftPointer;
    private int length;
    private byte[] queue;
    private int rightPointer;
    private int size;

    public void clear() {
        this.leftPointer = 0;
        this.rightPointer = 0;
        this.size = 0;
    }

    public byte poll() {
    L2:
        int r100 = this.size;
        if (r100 > 0) goto L9;
        Thread.sleep(200);     // Catch: InterruptedException -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L2
    L9:
        byte[] r101 = this.queue;
        int r102 = this.leftPointer;
        byte r103 = r101[r102];
        int r104 = r102 + 1;
        this.leftPointer = r104;
        this.leftPointer = r104 % this.length;
        this.size = r100 - 1;
        return r103;
    }

    public int size() {
        return this.size;
    }

    public ByteArrayQueue(int r100) {
        this.queue = new byte[r100];
        this.leftPointer = 0;
        this.rightPointer = 0;
        this.size = 0;
        this.length = r100;
    }

    public void offer(byte r100) {
    L2:
        int r101 = this.size;
        int r102 = this.length;
        if (r101 < r102) goto L9;
        Thread.sleep(200);     // Catch: InterruptedException -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L2
    L9:
        byte[] r103 = this.queue;
        int r104 = this.rightPointer;
        r103[r104] = r100;
        int r105 = r104 + 1;
        this.rightPointer = r105;
        this.rightPointer = r105 % r102;
        this.size = r101 + 1;
    }
}
