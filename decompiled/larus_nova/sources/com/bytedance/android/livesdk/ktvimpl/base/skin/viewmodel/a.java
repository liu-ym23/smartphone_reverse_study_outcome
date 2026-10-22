package com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.ktv.common.model.api.h0;
import com.bytedance.android.live.ktv.common.model.api.x0;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressPageItem;
import com.bytedance.android.livesdkapi.depend.message.TagDressPageItem;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes10.dex */
public interface a {
    void changeDress(int r100, String r101, String r102, int r103, int r104);

    TagDressPageItem getCurrentSelectHonorTag();

    MidiSkinDressPageItem getCurrentSelectMidiSkin();

    void getPageDressList();

    boolean hasNewKtvDress();

    void observeHonorTagList(LifecycleOwner r100, Observer<x0> r101);

    void observeKtvDressChangedState(LifecycleOwner r100, Observer<Pair<Integer, Integer>> r101);

    void observeMidiSkinList(LifecycleOwner r100, Observer<h0> r101);

    x0 obtainHonorTagList();

    h0 obtainMidiSkinList();

    void wearMidiSkin();
}
