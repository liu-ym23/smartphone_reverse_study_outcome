package com.bytedance.security.zenmobile.ahocorasick;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinkedListTrieNode {
    int base;
    List<LinkedListTrieNode> children;
    int code;
    int depth;
    int index;
    int left;
    int right;
    byte[] subKey;

    public byte getByteCode() {
        return (byte) (this.code - 1);
    }

    public LinkedListTrieNode() {
        this.children = new ArrayList();
    }

    public LinkedListTrieNode(int r1, int r2, int r3, int r4, byte[] r5) {
        this.code = r1;
        this.depth = r2;
        this.left = r3;
        this.right = r4;
        this.subKey = r5;
        this.children = new ArrayList();
    }
}
