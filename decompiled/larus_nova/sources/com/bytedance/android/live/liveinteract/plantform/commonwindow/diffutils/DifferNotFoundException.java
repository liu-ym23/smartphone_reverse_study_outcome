package com.bytedance.android.live.liveinteract.plantform.commonwindow.diffutils;

/* JADX INFO: loaded from: classes46.dex */
public class DifferNotFoundException extends RuntimeException {
    public DifferNotFoundException(Class<?> r100) {
        super("Do you have registered the differ for {className}.class in the DiffTypeTool?".replace("{className}", r100.getSimpleName()));
    }
}
